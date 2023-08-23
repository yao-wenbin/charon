package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.configuration.DataSourceConfiguration;
import io.github.yaowenbin.charon.datasource.pool.DataSourcePool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Service
@RequiredArgsConstructor
public class DataSourceService {

    DataSourceConfiguration dataSourceConfiguration;
    private final DataSourcePool datasoucePool;
    private final DataSourceCreator creator;

    @PostConstruct
    public void init() {
        // dataSourceConfiguration.getDataSourceConfigMap().forEach((key, property) -> {
        //    datasoucePool.addDataSource(key, );
        // });

    }


}
