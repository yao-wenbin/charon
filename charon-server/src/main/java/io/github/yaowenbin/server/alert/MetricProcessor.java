package io.github.yaowenbin.server.alert;

import io.github.yaowenbin.server.monitor.Metric;

import java.util.List;
import java.util.stream.Collectors;

public class MetricProcessor {

    private List<Rule> rules;

    public MetricProcessor(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> checkMetrics(Metric mockMetric) {
        return rules.stream().filter(rule -> rule.eval(mockMetric))
                .collect(Collectors.toList());
    }
}
