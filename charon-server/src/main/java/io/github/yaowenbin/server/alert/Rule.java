package io.github.yaowenbin.server.alert;

import io.github.yaowenbin.commons.map.Maps;
import io.github.yaowenbin.server.monitor.Metric;
import lombok.Data;
import lombok.experimental.Accessors;
import org.mvel2.MVEL;

import java.util.Map;


@Data
@Accessors(chain = true)
public class Rule {

    private String metricName;

    private String expression;

    private Long period;

    private String message;


    public boolean eval(Metric metric) {
        if (! getMetricName().equals(metric.getName())) {
            return false;
        }
        return (boolean) MVEL.eval(evalExpression(), evalParams(metric.getVal()));
    }

    private Map<String, Object> evalParams(Object val) {
        return Maps.<String, Object>builder().put("val", val).build();
    }

    private String evalExpression() {
        return "val ".concat(expression);
    }
}
