package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.SpringContextTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
class MultiDataSourceTest extends SpringContextTest {

    @Resource
    MultiDataSource dataSource;

    @Test
    void afterPropertiesSet() {
        // db1 come from charon-conf.yml
        assertThat(dataSource.getDataSource("db1")).isNotNull();
    }

    @Test
    void getConnection() {
        DataSourceHolder.push("");
    }

    @Test
    void testGetConnection() {
    }

    @Test
    void peekDataSource() {
    }

    @Test
    void getDataSource() {
    }

    @Test
    void addDataSource() {
    }

    @Test
    void removeDataSource() {
    }
}