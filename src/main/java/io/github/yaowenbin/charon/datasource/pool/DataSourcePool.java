package io.github.yaowenbin.charon.datasource.pool;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */
public interface DataSourcePool {

    Map<String, DataSource> dataSourceMap();

    DataSource getDataSource(String dataSourceName);

    void addDataSource(String key, DataSource dataSource);

    void removeDataSource(String key);
}
