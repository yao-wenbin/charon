package io.github.yaowenbin.server.alert;

import io.github.yaowenbin.server.UnitTest;
import io.github.yaowenbin.server.monitor.Metric;
import org.junit.jupiter.api.Test;

class RuleTest extends UnitTest {

    Rule rule = new Rule().setMetricName("metric").setPeriod(60L)
            .setExpression(">= 200").setMessage("something is already over 200");

    @Test
    void eval() {
        Metric mockMetric = new Metric().setName("other metric").setVal(300L);
        assertThat(rule.eval(mockMetric)).isFalse();

        mockMetric = new Metric().setName("metric").setVal(300L);
        assertThat(rule.eval(mockMetric)).isTrue();

        mockMetric = new Metric().setName("metric").setVal(199L);
        assertThat(rule.eval(mockMetric)).isFalse();
    }
}