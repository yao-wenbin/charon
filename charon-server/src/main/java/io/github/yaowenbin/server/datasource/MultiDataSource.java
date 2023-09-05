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
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class MultiDataSource extends AbstractDataSource implements DataSourceMap {

    private final Map<String/* DataSourceKey */, Pair<DataSourceMetaProperties, DataSource>> dataSourcePoolMap = new ConcurrentHashMap<>();

    public MultiDataSource(final DataSourceConfigurationProperties properties, final DataSourceCreator creator) {
        properties.getDatasource().forEach((key, property) -> {
            dataSourcePoolMap.put(key, new Pair<>(property, creator.create(property)));
        });
    }

    @Override
    public Connection getConnection() {
        Pair<DataSourceMetaProperties, DataSource> pair = peekOrFirstDataSource();
        try {
            return pair.val().getConnection();
            // it's need to cooperate with druid's max wait time to catch cannot connection timeout.
        } catch (Exception e) {
            throw new DataSourceException("cannot connection datasource:{}", pair.key().getUrl());
        }
    }

    @Override
    public Connection getConnection(String username, String password) {
        Pair<DataSourceMetaProperties, DataSource> pair = peekOrFirstDataSource();
        try {
            return pair.val().getConnection(username, password);
        } catch (SQLException e) {
            throw new DataSourceException("cannot connection datasource:{}", pair.key().getUrl());
        }
    }



    public Pair<DataSourceMetaProperties, DataSource> peekOrFirstDataSource() {
        String peekKey = DataSourceHolder.peek();
        if (Strings.isEmpty(peekKey)) {
            if (dataSourcePoolMap.isEmpty()) {
                throw new DataSourceException("Please set a datasource in charon-conf.yml");
            } else {
                return dataSourcePoolMap.values().stream().findFirst().get();
            }
        }
        return getPair(peekKey);
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
        return Optional.ofNullable(dataSourcePoolMap.get(key))
                .map(Pair::val)
                .orElseThrow(() -> new DataSourceException("cannot get DataSource by key: " + key));
    }

    public Pair<DataSourceMetaProperties, DataSource> getPair(String key) {
        return dataSourcePoolMap.get(key);
    }

    public void removeDataSource(String key) {
        dataSourcePoolMap.remove(key);
    }

}
