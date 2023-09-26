package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.commons.string.Strings;
import io.github.yaowenbin.server.alert.config.AlerterProperties;

public class AlerterFactory {

    private AlerterFactory() {}

    public static Alerter build(AlerterProperties properties) {
        var webhook = properties.getWebhook();
        var type = Alerter.Type.of(properties.getType()).orElseThrow(() ->
                new UnsupportedOperationException(Strings.format("can not recognized with type: {}",
                        properties.getType())));

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
