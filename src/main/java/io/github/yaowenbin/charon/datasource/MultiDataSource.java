package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.autoconfiguration.DataSourceConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
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
@RequiredArgsConstructor
public class MultiDataSource extends AbstractDataSource implements InitializingBean {

    private final Map<String/* DataSourceKey */, DataSource> dataSourcePoolMap = new ConcurrentHashMap<>();
    private final DataSourceConfigurationProperties properties;
    private final DataSourceCreator creator;

    /**
     * initializing users datasource.
     */
    @Override
    public void afterPropertiesSet() {
        properties.getDatasource().forEach((key, property) -> {
            dataSourcePoolMap.put(key, creator.create(property));
        });
    }

    @Override
    public Connection getConnection() throws SQLException {
        return peekDataSource().getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return peekDataSource().getConnection(username, password);
    }

    public DataSource peekDataSource() {
        return getDataSource(DataSourceHolder.peek());
    }

    public DataSource getDataSource(String key) {
        DataSource ds = dataSourcePoolMap.get(key);
        if (ds == null) {
            throw new DataSourceException("Please using @DS or DataSourceHolder#push() API to select a DataSource First");
        }
        return ds;
    }

    public void addDataSource(String key, DataSource dataSource) {
        dataSourcePoolMap.put(key, dataSource);
    }

    public void removeDataSource(String key) {
        dataSourcePoolMap.remove(key);
    }

}
