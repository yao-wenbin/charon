package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.map.Maps;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;


public class DataSourceTestFixture {

    public static DataSourceCreator creator = new DataSourceCreator();

    public static DataSourceMetaProperties dataSourceMetaProperties = new DataSourceMetaProperties()
            .setUrl("jdbc:mysql://127.0.0.1:3306/charon")
            .setUsername("root")
            .setPassword("root");

    public static DataSourceConfigurationProperties configurationProperties = new DataSourceConfigurationProperties()
            .setDatasource(Maps.<String, DataSourceMetaProperties>builder().put("db1", dataSourceMetaProperties).build());

    public static MultiDataSource multiDataSource = new MultiDataSource(configurationProperties, creator);

    public static DataSourceMetaProperties mockMetaProperties() {
        return dataSourceMetaProperties;
    }

    public static MultiDataSource mockMultiDataSource() {
        return multiDataSource;
    }




}
