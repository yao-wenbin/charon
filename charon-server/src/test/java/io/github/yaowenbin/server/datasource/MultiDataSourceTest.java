package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.server.SpringContextTest;
import io.github.yaowenbin.server.datasource.core.DataSourceException;
import io.github.yaowenbin.server.datasource.core.DataSourceHolder;
import io.github.yaowenbin.server.datasource.core.MultiDataSource;
import org.junit.jupiter.api.Assertions;
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
        assertThat(dataSource.get("db1")).isNotNull();
    }

    @Test
    void get_shouldThrowException_whenGetUnknownDS() {
        Assertions.assertThrows(DataSourceException.class, () -> dataSource.get("db9999"));
    }

    @Test
    void get_shouldThrowException_whenGetDSCannotConnection() {
        DataSourceHolder.push("db2");
        Assertions.assertThrows(DataSourceException.class, () -> dataSource.getConnection());
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