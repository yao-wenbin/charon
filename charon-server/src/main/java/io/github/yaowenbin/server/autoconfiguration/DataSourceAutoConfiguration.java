package io.github.yaowenbin.server.autoconfiguration;

import io.github.yaowenbin.server.datasource.core.MultiDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.nio.file.Path;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
@Configuration
@RequiredArgsConstructor
@AutoConfigureBefore(value = DataSourceAutoConfiguration.class, name = "com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure")
public class DataSourceAutoConfiguration {

    private final CharonConfigProperties properties;

    // for using autoconfigurationBefore to createDataSource before DruidDataSourceAutoConfigure.
    @Bean
    public DataSource dataSource() {
        return new MultiDataSource(properties);
    }


    // @Value("spring.config.additional-location")
    // String configPath;
    //
    // @Bean
    // @ConditionalOnProperty(prefix = "spring.config", name = "additional-location")
    // public ConfigFileWatcher fileWatcher() {
    //     return new ConfigFileWatcher();
    // }


}
