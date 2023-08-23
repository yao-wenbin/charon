package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.autoconfiguration.DataSourceConfiguration;
import io.github.yaowenbin.charon.datasource.pool.DataSourcePool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Service
@RequiredArgsConstructor
@Getter
public class DataSourceService {

    private final DataSourceConfiguration dataSourceConfiguration;
    private final DataSourcePool datasoucePool;
    private final DataSourceCreator dsCreator;

    @PostConstruct
    public void init() {
        dataSourceConfiguration.getDatasource().forEach((key, property) -> {
           datasoucePool.addDataSource(key, dsCreator.create(property));
        });
    }


}
