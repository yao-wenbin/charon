package io.github.yaowenbin.charon.autoconfiguration;

import io.github.yaowenbin.charon.SpringContextTest;
import io.github.yaowenbin.charon.datasource.MultiDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
class DataSourceAutoConfigurationTest extends SpringContextTest{

    @Resource
    DataSource dataSource;

    @Resource
    SqlSessionFactory sqlSessionFactoryBean;

    @Test
    void injectMultiDataSource() {
        assertThat(dataSource).isInstanceOf(MultiDataSource.class);
    }


    @Test
    void sqlSessionFactoryBean() {
        assertThat(sqlSessionFactoryBean).isNotNull();
    }
}