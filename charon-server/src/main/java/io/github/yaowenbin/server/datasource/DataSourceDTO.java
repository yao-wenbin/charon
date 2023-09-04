package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.Data;

@Data
public class DataSourceDTO {

    private final String username;

    private final String url;

    public DataSourceDTO transferFrom(DataSourceMetaProperties metaProperties) {
        return new DataSourceDTO(metaProperties.getUsername(), metaProperties.getUrl());
    }

}
