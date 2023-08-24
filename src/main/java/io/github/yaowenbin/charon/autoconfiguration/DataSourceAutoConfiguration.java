package io.github.yaowenbin.charon.autoconfiguration;

import io.github.yaowenbin.charon.autoconfiguration.properties.DataSourceConfigurationProperties;
import io.github.yaowenbin.charon.datasource.DataSourceCreator;
import io.github.yaowenbin.charon.datasource.MultiDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
@Configuration
@RequiredArgsConstructor
@AutoConfigureBefore(value = DataSourceAutoConfiguration.class, name = "com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure")
public class DataSourceAutoConfiguration {

    private final DataSourceConfigurationProperties properties;

    private final DataSourceCreator creator;

    @Bean
    public DataSource dataSource() {
        return new MultiDataSource(properties, creator);
    }

}
