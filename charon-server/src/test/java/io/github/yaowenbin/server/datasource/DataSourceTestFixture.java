package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.map.Maps;
import io.github.yaowenbin.server.autoconfiguration.CharonConfigProperties;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import io.github.yaowenbin.server.datasource.core.MultiDataSource;


public class DataSourceTestFixture {

    public static DataSourceMetaProperties dataSourceMetaProperties = new DataSourceMetaProperties()
            .setUrl("jdbc:mysql://127.0.0.1:3306/charon")
            .setUsername("root")
            .setPassword("root");

    public static CharonConfigProperties configurationProperties = new CharonConfigProperties()
            .setDatasource(Maps.<String, DataSourceMetaProperties>builder().put("db1", dataSourceMetaProperties).build());

    public static MultiDataSource multiDataSource = new MultiDataSource(configurationProperties);

    public static DataSourceMetaProperties mockMetaProperties() {
        return dataSourceMetaProperties;
    }

    public static MultiDataSource mockMultiDataSource() {
        return multiDataSource;
    }




}
