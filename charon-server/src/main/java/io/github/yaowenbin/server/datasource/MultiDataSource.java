package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.map.Pair;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.jdbc.datasource.AbstractDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class MultiDataSource extends AbstractDataSource implements DataSourceMap {

    private final Map<String/* DataSourceKey */, Pair<DataSourceMetaProperties, DataSource>> dataSourcePoolMap = new ConcurrentHashMap<>();
    private final DataSourceConfigurationProperties properties;
    private final DataSourceCreator creator;

    public MultiDataSource(final DataSourceConfigurationProperties properties, final DataSourceCreator creator) {
        this.properties = properties;
        this.creator = creator;
        properties.getDatasource().forEach((key, property) -> {
            dataSourcePoolMap.put(key, new Pair<>(property, creator.create(property)));
        });
    }

    @Override
    public Connection getConnection() throws SQLException {
        return peekOrFirstDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return peekOrFirstDataSource().getConnection(username, password);
    }



    public DataSource peekOrFirstDataSource() {
        String peekKey = DataSourceHolder.peek();
        if (Strings.isEmpty(peekKey)) {
            if (dataSourcePoolMap.isEmpty()) {
                throw new DataSourceException("Please set a datasource in charon-conf.yml");
            } else {
                return dataSourcePoolMap.values().stream().findFirst().get().val();
            }
        }
        return get(peekKey);
    }

    public DataSource peekDataSource() {
        return get(DataSourceHolder.peek());
    }

    @Override
    public Map<String, Pair<DataSourceMetaProperties, DataSource>> dataSourceMap() {
        return dataSourcePoolMap;
    }

    @Override
    public DataSource get(String key) {
        DataSource ds = dataSourcePoolMap.get(key).val();
        if (ds == null) {
            throw new DataSourceException("cannot get DataSource by key: " + key);
        }
        return ds;
    }

    public void removeDataSource(String key) {
        dataSourcePoolMap.remove(key);
    }

}
