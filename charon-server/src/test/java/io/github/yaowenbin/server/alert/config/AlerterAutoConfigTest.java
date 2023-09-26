package io.github.yaowenbin.server.alert.config;

import io.github.yaowenbin.server.SpringContextTest;
import io.github.yaowenbin.server.alert.alerter.AlerterMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


/**
 * IntegrationTest depends on resources/charon-conf.yml
 */

class AlerterAutoConfigTest extends SpringContextTest {

    @Resource
    AlerterProcessor processor;

    @Test
    void load() {
        assertThat(processor).isNotNull();
    }

    @Test
    void sendAlert() {
        var message = new AlerterMessage().setMessage("you have a alerter message right now.");
        Assertions.assertDoesNotThrow(() -> processor.sendAlert(message));
    }

}