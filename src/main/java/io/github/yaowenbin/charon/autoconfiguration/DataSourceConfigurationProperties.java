package io.github.yaowenbin.charon.autoconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Data
@ConfigurationProperties
public class DataSourceConfigurationProperties {

    private Map<String, DataSourceMetaProperties> datasource = new HashMap<>();

}
