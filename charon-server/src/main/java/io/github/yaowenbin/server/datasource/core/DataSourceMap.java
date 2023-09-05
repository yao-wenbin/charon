package io.github.yaowenbin.server.datasource.core;

import io.github.yaowenbin.commons.map.Pair;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;

import javax.sql.DataSource;
import java.util.Map;

public interface DataSourceMap {

    Map<String, Pair<DataSourceMetaProperties, DataSource>> dataSourceMap();

    DataSource get(String key);

}
