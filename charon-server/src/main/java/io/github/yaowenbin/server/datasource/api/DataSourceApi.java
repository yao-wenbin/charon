package io.github.yaowenbin.server.datasource.api;

import io.github.yaowenbin.core.http.R;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import io.github.yaowenbin.server.datasource.core.DataSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@RestController
@RequiredArgsConstructor
public class DataSourceApi{

    private final DataSourceConfigurationProperties dataSourceProperties;

    private final DataSourceService dataSourceService;

    @GetMapping("/datasources")
    public R<Collection<DataSourceMetaDTO>> datasourcesApi() {
        return R.success(dataSourceService.collection());
    }

}
