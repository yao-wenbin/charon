package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.server.UnitTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class AleterTest extends UnitTest {

    RestTemplate restTemplate = new RestTemplate();

    FeishuAlerter feishuAlerter = new FeishuAlerter("https://open.feishu.cn/open-apis/bot/v2/hook/c3be04d2-ac6f-41fd-8288-3c0b7c93b71d");

    AlerterMessage msg = new AlerterMessage().setMessage("you having a alert right now.");

    @Test
    void sendAlert_feishu() {
        feishuAlerter.sendAlert(msg);
    }

    // WeixinAlerter weixinAlerter
    WeixinAlerter weixinAlerter = new WeixinAlerter("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=30a89145-063f-46d4-82f3-2671107b8ae2", restTemplate);

    @Test
    void sendAlert_weixin() {
        weixinAlerter.sendAlert(msg);
    }

}