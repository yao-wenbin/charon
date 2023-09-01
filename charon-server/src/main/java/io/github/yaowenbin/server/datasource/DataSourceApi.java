package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.core.http.R;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@RestController
@RequiredArgsConstructor
public class DataSourceApi{

    private final DataSourceConfigurationProperties dataSourceProperties;

    @GetMapping("/datasources")
    public R<DataSourceConfigurationProperties> listApi() {
        return R.success(dataSourceProperties);
    }

}
