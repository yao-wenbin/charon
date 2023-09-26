package io.github.yaowenbin.server.alert.alerter;

import io.github.yaowenbin.server.UnitTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AleterTest extends UnitTest {

    FeishuAlerter feishuAlerter = new FeishuAlerter("https://open.feishu.cn/open-apis/bot/v2/hook/c3be04d2-ac6f-41fd-8288-3c0b7c93b71d");

    AlerterMessage msg = new AlerterMessage().setMessage("you having a alert right now.");

    @Test
    void sendAlert_feishu() throws InterruptedException, ExecutionException, TimeoutException {
        CompletableFuture<Void> future =
                feishuAlerter.sendAlert(msg);
        future.get(5000, TimeUnit.MILLISECONDS);
    }

    // WeixinAlerter weixinAlerter
    WeixinAlerter weixinAlerter = new WeixinAlerter("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=30a89145-063f-46d4-82f3-2671107b8ae2");

    @Test
    void sendAlert_weixin() throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Void> future = weixinAlerter.sendAlert(msg);
        future.get(5000, TimeUnit.MILLISECONDS);
    }

}