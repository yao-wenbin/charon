package io.github.yaowenbin.server.datasource.core;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.jdbc.datasource.AbstractDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class MultiDataSource extends AbstractDataSource implements DataSourceMap {

    private final Map<String/* DataSourceKey */, DataSource> dataSourcePoolMap = new ConcurrentHashMap<>();

    public MultiDataSource(final DataSourceConfigurationProperties properties) {
        properties.getDatasource().forEach((key, property) ->
            dataSourcePoolMap.put(key, DataSourceFactory.build(property))
        );
    }

    @Override
    public Connection getConnection() {
        DataSource dataSource = peekOrFirstDataSource();
        try {
            return dataSource.getConnection();
            // it's need to cooperate with druid's max wait time to catch cannot connection timeout.
        } catch (Exception e) {
            throw new DataSourceException("cannot connection datasource:{}", ((DruidDataSource)dataSource).getUrl());
        }
    }

    @Override
    public Connection getConnection(String username, String password) {
        DataSource dataSource = peekOrFirstDataSource();
        try {
            return dataSource.getConnection(username, password);
            // it's need to cooperate with druid's max wait time to catch cannot connection timeout.
        } catch (Exception e) {
            throw new DataSourceException("cannot connection datasource:{}", ((DruidDataSource)dataSource).getUrl());
        }
    }

    public DataSource peekOrFirstDataSource() {
        String peekKey = DataSourceHolder.peek();
        if (Strings.isEmpty(peekKey)) {
            if (dataSourcePoolMap.isEmpty()) {
                throw new DataSourceException("Please set a datasource in charon-conf.yml");
            } else {
                return dataSourcePoolMap.values().stream().findFirst().get();
            }
        }
        return get(peekKey);
    }

    @Override
    public Map<String, DataSource> dataSourceMap() {
        return dataSourcePoolMap;
    }

    @Override
    public DataSource get(String key) {
        return Optional.ofNullable(dataSourcePoolMap.get(key))
                .orElseThrow(() -> new DataSourceException("cannot get DataSource by key: " + key));
    }


}
