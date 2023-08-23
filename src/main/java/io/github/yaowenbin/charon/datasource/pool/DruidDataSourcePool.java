package io.github.yaowenbin.charon.datasource.pool;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */
@Component
public class DruidDataSourcePool implements DataSourcePool {

    private Map<String/* DataSourceName */, DataSource> dataSourcePoolMap = new ConcurrentHashMap<>();

    @Override
    public Map<String, DataSource> dataSourceMap() {
        return dataSourcePoolMap;
    }

    @Override
    public DataSource getDataSource(String key) {
        return dataSourcePoolMap.get(key);
    }

    @Override
    public void addDataSource(String key, DataSource dataSource) {
        dataSourcePoolMap.put(key, dataSource);
    }

    @Override
    public void removeDataSource(String key) {
        dataSourcePoolMap.remove(key);
    }
}
