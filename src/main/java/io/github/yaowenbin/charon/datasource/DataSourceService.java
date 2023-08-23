package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.autoconfiguration.DataSourceConfiguration;
import io.github.yaowenbin.charon.datasource.pool.DataSourcePool;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Service
@RequiredArgsConstructor
public class DataSourceService {

    private final DataSourceConfiguration dataSourceConfiguration;
    private final DataSourcePool datasoucePool;
    private final DataSourceCreator dsCreator;
    private final Environment env;

    @PostConstruct
    public void init() {
        env.getProperty("datasource");
        dataSourceConfiguration.getDatasource().forEach((key, property) -> {
           datasoucePool.addDataSource(key, dsCreator.create(property));
        });
    }


}
