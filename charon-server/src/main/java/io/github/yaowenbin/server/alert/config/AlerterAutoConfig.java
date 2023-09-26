package io.github.yaowenbin.server.alert.config;

import io.github.yaowenbin.server.alert.alerter.Alerter;
import io.github.yaowenbin.server.alert.alerter.AlerterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;


@Configuration
@RequiredArgsConstructor
public class AlerterAutoConfig {

    private final AlertProperties alertProperties;

    @Bean
    public AlerterProcessor alerters() {
        List<Alerter> alerters = alertProperties.getAlerter().stream()
                .map(AlerterFactory::build)
                .collect(Collectors.toList());

        return new AlerterProcessor(alerters);
    }


}
