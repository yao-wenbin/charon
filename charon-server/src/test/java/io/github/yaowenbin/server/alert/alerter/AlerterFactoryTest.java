package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.server.UnitTest;
import io.github.yaowenbin.server.alert.config.AlerterProperty;
import io.github.yaowenbin.server.core.LoadConfigurationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AlerterFactoryTest extends UnitTest {

    @Test
    void build_shouldThrowException_whenTypeIsUnsupported() {
        var property = new AlerterProperty().setType("slack").setWebhook("anything");
        assertThrows(LoadConfigurationException.class, () -> {
            AlerterFactory.build(property);
        });
    }

    @Test
    void build_feishuAlerter() {
        var property = new AlerterProperty().setType("feishu").setWebhook("some feishu webhook");
        Alerter alerter = AlerterFactory.build(property);
        assertThat(alerter).isInstanceOf(FeishuAlerter.class);
    }

    @Test
    void build_weixinAlerter() {
        var property = new AlerterProperty().setType("weixin").setWebhook("some weixin webhook");
        Alerter alerter = AlerterFactory.build(property);
        assertThat(alerter).isInstanceOf(WeixinAlerter.class);
    }

}