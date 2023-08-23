package io.github.yaowenbin.charon.autoconfiguration;

import io.github.yaowenbin.charon.datasource.DataSourceCreator;
import io.github.yaowenbin.charon.datasource.MultiDataSource;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
@Configuration
@RequiredArgsConstructor
public class DataSourceAutoConfiguration {

    private final DataSourceConfigurationProperties properties;

    private final DataSourceCreator creator;

    @Bean
    public DataSource dataSource() {
        return new MultiDataSource(properties, creator);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionfactoryBean = new SqlSessionFactoryBean();
        // key to achieve dynamic switch to MyBatis.
        sqlSessionfactoryBean.setDataSource(dataSource());
        return sqlSessionfactoryBean;
    }

}
