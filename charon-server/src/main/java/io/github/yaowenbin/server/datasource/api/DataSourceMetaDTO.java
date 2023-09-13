package io.github.yaowenbin.server.datasource.api;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.commons.list.Lists;
import io.github.yaowenbin.commons.map.Pair;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.Data;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
public class DataSourceMetaDTO {

    private final String key;

    private final String username;

    private final String url;

    private final boolean connected;

    public static Collection<DataSourceMetaDTO> transferFrom(Map<String,  DataSource> datasourceMap) {
        List<DataSourceMetaDTO> res = Lists.newArrayList();
        datasourceMap.forEach((dbName, ds) -> {
            DruidDataSource druid = (DruidDataSource) ds;
            res.add(new DataSourceMetaDTO(dbName, druid.getUsername(), druid.getRawJdbcUrl(), druid.getActiveCount() > 0));
        });
        return res;
    }

}
