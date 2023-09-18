package io.github.yaowenbin.server.autoconfiguration;

import io.github.yaowenbin.server.SpringContextTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class CharonConfigPropertiesTest extends SpringContextTest {

    @Resource
    CharonConfigProperties properties;

    @Test
    public void init() {
        log.info("{}", properties);
    }

}