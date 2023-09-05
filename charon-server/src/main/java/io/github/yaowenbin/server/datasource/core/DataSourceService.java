package io.github.yaowenbin.server.datasource.core;

import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import io.github.yaowenbin.server.datasource.api.DataSourceMetaDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;


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

    public Collection<DataSourceMetaDTO> collection() {
        return DataSourceMetaDTO.transferFrom(dataSource.dataSourceMap());
    }

}
