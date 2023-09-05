package io.github.yaowenbin.server.datasource.api;

import io.github.yaowenbin.commons.list.Lists;
import io.github.yaowenbin.commons.map.Pair;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.Data;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
public class DataSourceMetaDTO {

    private final String key;

    private final String username;

    private final String url;

    public static Collection<DataSourceMetaDTO> transferFrom(Map<String, Pair<DataSourceMetaProperties, DataSource>> datasourceMap) {
        List<DataSourceMetaDTO> res = Lists.newArrayList();
        datasourceMap.forEach((dbName, pair) -> {
            DataSourceMetaProperties metaProperty = pair.key();
            res.add(new DataSourceMetaDTO(dbName, metaProperty.getUsername(), metaProperty.getUrl()));
        });
        return res;
    }

}
