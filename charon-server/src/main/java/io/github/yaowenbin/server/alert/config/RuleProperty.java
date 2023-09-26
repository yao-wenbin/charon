package io.github.yaowenbin.server.alert.config;

import lombok.Data;

@Data
public class RuleProperty {

    private String metricName;

    private String expression;

    private String period;

    private String message;

}
