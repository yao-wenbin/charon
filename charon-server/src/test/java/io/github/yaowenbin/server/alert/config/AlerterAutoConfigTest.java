package io.github.yaowenbin.server.alert.config;

import io.github.yaowenbin.server.SpringContextTest;
import io.github.yaowenbin.server.alert.alerter.Alerter;
import io.github.yaowenbin.server.alert.alerter.FeishuAlerter;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;



class AlerterAutoConfigTest extends SpringContextTest {

    @Resource
    Alerter alerter;

    @Test
    void load() {
        assertThat(alerter).isNotNull();
        assertThat(alerter).isInstanceOf(FeishuAlerter.class);
    }

}