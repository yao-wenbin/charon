package io.github.yaowenbin.server.autoconfiguration;

import io.github.yaowenbin.server.refresh.Refresh;
import io.github.yaowenbin.server.refresh.RefreshTest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    // @Bean
    // @Refresh
    // public DataSource dataSource() {
    //     return new MultiDataSource(properties.getDatasource());
    // }

    @Bean
    @Refresh
    public RefreshTest refreshTest() {
        return new RefreshTest();
    }

}
