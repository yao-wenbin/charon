package io.github.yaowenbin.server.refresh;

import io.github.yaowenbin.server.SpringContextTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ImportAutoConfiguration(RefreshAutoConfiguration.class)
class RefreshTestTest extends SpringContextTest {

    @Resource
    RefreshTest refreshTest;

    @Autowired
    RefreshScope refreshScope;


    @Test
    void load() {
        RefreshTest tmp = refreshTest;

        refreshScope.refreshAll();

        assertNotEquals(refreshScope, tmp);
    }





}