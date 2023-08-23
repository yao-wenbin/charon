package io.github.yaowenbin.charon.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.charon.autoconfiguration.DataSourceProperty;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */
@Component
public class DataSourceCreator {

    public DataSource create(DataSourceProperty property) {
        DruidDataSource druid = new DruidDataSource();
        druid.setUsername(property.getUsername());
        druid.setPassword(property.getPassword());
        druid.setUrl(property.getUrl());

        if (Boolean.FALSE.equals(property.getLazy())) {
            try {
                druid.init();
            } catch (SQLException e) {
                throw new InitDataSourceException("druid initial error",e);
            }
        }
        return druid;
    }

}
