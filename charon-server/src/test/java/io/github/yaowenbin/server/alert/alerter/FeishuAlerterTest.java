package io.github.yaowenbin.server.alert.alerter;

import org.junit.jupiter.api.Test;

class FeishuAlerterTest {

    FeishuAlerter alerter = new FeishuAlerter("https://open.feishu.cn/open-apis/bot/v2/hook/c3be04d2-ac6f-41fd-8288-3c0b7c93b71d");

    @Test
    void sendAlert() {
        var msg = new AlerterMessage().setMessage("you having a alert right now.");
        alerter.sendAlert(msg);
    }

}