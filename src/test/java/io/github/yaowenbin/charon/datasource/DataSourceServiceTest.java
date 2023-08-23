package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.Resource;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
@TestPropertySource("classpath:/charon-conf.properties")
@ContextConfiguration
class DataSourceServiceTest extends IntegrationTest {

    @Resource
    DataSourceService dataSourceService;

    @Test
    void init() {
        log.info("{}", dataSourceService.getDatasoucePool().dataSourceMap());
    }

}