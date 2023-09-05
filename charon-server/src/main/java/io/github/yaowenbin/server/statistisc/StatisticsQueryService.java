package io.github.yaowenbin.server.statistisc;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.server.datasource.core.DataSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticsQueryService {

    private final DataSourceService dataSourceService;

    public StatisticsIndexDTO index() {

        long dataSourceCount = dataSourceService.collection().size();
        Map<String, DataSource> dataSourcePool = dataSourceService.getDataSource().dataSourceMap();
        long connectionCount = dataSourcePool.values().stream()
                .map(val ->
            ((DruidDataSource)val).getActiveCount()
        ).reduce(0, Integer::sum);
        return new StatisticsIndexDTO(dataSourceCount, connectionCount);
    }
}
