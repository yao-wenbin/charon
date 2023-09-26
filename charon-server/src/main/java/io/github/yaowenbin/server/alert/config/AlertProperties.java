package io.github.yaowenbin.server.alert.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("alert")
public class AlertProperties {

    private List<AlerterProperties> alerter;

    private List<RuleProperties> rule;

}

