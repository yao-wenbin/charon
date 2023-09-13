package io.github.yaowenbin.server.datasource.core;


import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 * to convert datasource property to real druid datasource.
 */
@Slf4j
public class DataSourceFactory {

    private static final DruidDataSource templateDataSource;

    static {
        templateDataSource = new DruidDataSource();
        templateDataSource.setMaxActive(10);
        templateDataSource.setTestWhileIdle(true);
        templateDataSource.setConnectionErrorRetryAttempts(0);
        templateDataSource.setMaxWait(2000);
        templateDataSource.setInitialSize(1);
        // stop druid try connection after connection failure.
        templateDataSource.setBreakAfterAcquireFailure(true);
        templateDataSource.setAsyncInit(true);
    }

    public static DataSource build(DataSourceMetaProperties property) {
        DruidDataSource druid = templateDataSource.cloneDruidDataSource();
        druid.setUsername(property.getUsername());
        druid.setPassword(property.getPassword());
        druid.setUrl(property.getUrl());
        try {
            druid.init();
            log.info("datasource: {} loaded", property.getUrl());
        } catch (SQLException e) {
            log.warn("druid initial error: ", e);
        }
        return druid;
    }

}
