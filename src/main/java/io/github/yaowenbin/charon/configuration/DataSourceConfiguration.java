package io.github.yaowenbin.charon.configuration;

import io.github.yaowenbin.charon.datasource.DataSourceProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@ConfigurationProperties(prefix = "datasource")
@Configuration
@Data
public class DataSourceConfiguration {

    private Map<String, DataSourceProperty> dataSourceConfigMap;

}