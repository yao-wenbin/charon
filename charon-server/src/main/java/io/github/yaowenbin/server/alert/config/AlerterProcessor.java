package io.github.yaowenbin.server.alert.config;

import io.github.yaowenbin.server.alert.alerter.Alerter;
import io.github.yaowenbin.server.alert.alerter.AlerterMessage;

import java.util.List;

public class AlerterProcessor {

    private List<Alerter> alerters;

    public AlerterProcessor(List<Alerter> alerters) {
        this.alerters = alerters;
    }

    public void sendAlert(AlerterMessage msg) {
        for (Alerter alerter : alerters) {
            alerter.sendAlert(msg);
        }
    }
}
