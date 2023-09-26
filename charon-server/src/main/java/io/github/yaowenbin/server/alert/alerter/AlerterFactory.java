package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.server.alert.config.AlerterProperty;
import io.github.yaowenbin.server.core.LoadConfigurationException;

public class AlerterFactory {

    private AlerterFactory() {}

    public static Alerter build(AlerterProperty properties) {
        var webhook = properties.getWebhook();
        var type = Alerter.Type.of(properties.getType()).orElseThrow(() ->
                new LoadConfigurationException("can not recognized with type: {}",
                        properties.getType()));

        return switch (type) {
            case DING -> null;
            case FEISHU ->
                new FeishuAlerter(webhook);
            case WEIXIN ->
                new WeixinAlerter(webhook);
            case MAIL -> null;
        };
    }

}
