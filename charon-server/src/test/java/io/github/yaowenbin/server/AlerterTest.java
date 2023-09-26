package io.github.yaowenbin.server;

import io.github.yaowenbin.server.alert.alerter.Alerter;
import io.github.yaowenbin.server.alert.alerter.FeishuAlerter;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class AlerterTest extends SpringContextTest {

    @Resource
    Alerter alerter;

    @Test
    void alerter() {
        assertThat(alerter).isNotNull();
        assertThat(alerter).isInstanceOf(FeishuAlerter.class);

    }

}
