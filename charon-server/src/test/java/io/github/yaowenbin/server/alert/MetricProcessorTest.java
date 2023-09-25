package io.github.yaowenbin.server.alert;

import io.github.yaowenbin.commons.list.Lists;
import io.github.yaowenbin.server.UnitTest;
import io.github.yaowenbin.server.monitor.Metric;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class MetricProcessorTest extends UnitTest {
        
    MetricProcessor metricProcessor = new MetricProcessor(Lists.<Rule>builder()
            .add(new Rule().setMetricName("noSqlIndexed").setExpression(">=200")
                    .setPeriod(2000L).setMessage("current no sql indexed has been over 200"))
            .add(new Rule().setMetricName("other rule").setExpression(">=200")
                    .setPeriod(2000L).setMessage("other rule")).build()
    );


    @Test
    void run() {
        Metric mockMetric = mockMetric();
        List<Rule> rules = metricProcessor.checkMetrics(mockMetric);
        assertThat(rules).hasSize(1);
        assertThat(rules.get(0).getMetricName()).isEqualTo("noSqlIndexed");
    }

    private Metric mockMetric() {
        Metric metric = new Metric();
        metric.setCreateTime(new Date());
        metric.setName("noSqlIndexed");
        metric.setType(1);
        metric.setVal(20000L);
        return metric;
    }
    
    
}