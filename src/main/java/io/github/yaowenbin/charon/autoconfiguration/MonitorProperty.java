package io.github.yaowenbin.charon.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@ConfigurationProperties(prefix = "monitor")
@Configuration
public class MonitorProperty {

    private String interval;

    private Long intervalMs;

    public void setInterval(String interval) {
        this.interval = interval;
        this.intervalMs =intervalMs;
    }

}
