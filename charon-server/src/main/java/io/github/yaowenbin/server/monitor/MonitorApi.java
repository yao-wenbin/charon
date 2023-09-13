package io.github.yaowenbin.server.monitor;

import io.github.yaowenbin.commons.map.Maps;
import io.github.yaowenbin.core.http.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class MonitorApi {

    private final MonitorService monitorService;

    @GetMapping("/monitor/unindexedSqls")
    public R<Collection<UnindexedSql>> listApi() {
        return R.success(monitorService.listUnindexedSql());
    }

    @GetMapping("/monitor/mysql-threads")
    public R<Collection<MysqlThread>> threadCollectionApi() {
        return R.success(monitorService.collectMysqlThreads());
    }

}
