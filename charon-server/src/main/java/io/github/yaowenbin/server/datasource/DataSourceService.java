package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.map.Pair;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Service
@RequiredArgsConstructor
@Getter
public class DataSourceService {

    private final MultiDataSource dataSource;

    public Collection<DataSourceMetaProperties> collection() {
        return dataSource.dataSourceMap().values().stream().map(Pair::key).collect(Collectors.toList());
    }

}
