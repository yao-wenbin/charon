package io.github.yaowenbin.server.datasource.core;


import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 * to convert datasource property to real druid datasource.
 */
@Component
public class DataSourceCreator {

    public DataSource create(DataSourceMetaProperties property) {
        DruidDataSource druid = new DruidDataSource();
        druid.setUsername(property.getUsername());
        druid.setPassword(property.getPassword());
        druid.setUrl(property.getUrl());
        druid.setAsyncInit(true);
        druid.setConnectionErrorRetryAttempts(0);
        druid.setMaxWait(2000);
        // stop druid try connection after connection failure.
        druid.setBreakAfterAcquireFailure(true);
        try {
            druid.init();
        } catch (SQLException e) {
            throw new DataSourceException("druid initial error",e);
        }

        return druid;
    }

}
