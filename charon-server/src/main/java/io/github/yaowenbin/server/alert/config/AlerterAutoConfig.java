package io.github.yaowenbin.server.alert.config;

import io.github.yaowenbin.server.alert.alerter.Alerter;
import io.github.yaowenbin.server.alert.alerter.FeishuAlerter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
@RequiredArgsConstructor
public class AlerterAutoConfig {

    private final AlertProperties alertProperties;

    private final Environment environment;

    @Bean
    public Alerter alerters() {
        return new FeishuAlerter(alertProperties.getAlerter().get(0).getWebhook());
    }


}
