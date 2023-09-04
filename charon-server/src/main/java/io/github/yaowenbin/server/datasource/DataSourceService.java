package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.map.Pair;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.stream.Collectors;


/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Service
@Getter
public class DataSourceService {

    @Resource
    private MultiDataSource dataSource;

    public void setDataSource(MultiDataSource multiDataSource) {
        this.dataSource = multiDataSource;
    }

    public Collection<DataSourceMetaProperties> collection() {
        return dataSource.dataSourceMap().values().stream().map(Pair::key).collect(Collectors.toList());
    }

}
