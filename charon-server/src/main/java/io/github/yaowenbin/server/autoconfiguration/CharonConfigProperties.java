package io.github.yaowenbin.server.autoconfiguration;

import io.github.yaowenbin.commons.bean.Beans;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties
@Data
public class CharonConfigProperties {

    private Map<String, DataSourceMetaProperties> datasource = new HashMap<>();

    private List<AlertConfigProperties> alert;

    public void reloadFrom(CharonConfigProperties newConfig) {
        Beans.copyProperties(newConfig, this);
    }
}
