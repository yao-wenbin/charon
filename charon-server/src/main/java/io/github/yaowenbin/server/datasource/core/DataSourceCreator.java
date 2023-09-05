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
@Component
@Slf4j
public class DataSourceCreator {

    public DataSource create(DataSourceMetaProperties property) {
        DruidDataSource druid = new DruidDataSource();
        druid.setUsername(property.getUsername());
        druid.setPassword(property.getPassword());
        druid.setUrl(property.getUrl());
        druid.setConnectionErrorRetryAttempts(0);
        druid.setMaxWait(2000);
        // stop druid try connection after connection failure.
        druid.setBreakAfterAcquireFailure(true);
        druid.setAsyncInit(true);
        try {
            druid.init();
            druid.getConnection();
        } catch (SQLException e) {
            log.warn("druid initial error: ", e);
        }

        return druid;
    }

}
