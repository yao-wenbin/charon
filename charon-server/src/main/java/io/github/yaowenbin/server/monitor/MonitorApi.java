package io.github.yaowenbin.server.monitor;

import io.github.yaowenbin.commons.map.Maps;
import io.github.yaowenbin.core.http.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class MonitorApi {

    private final MonitorService monitorService;

    @GetMapping("/monitor/unindexedSqls")
    public R<Map> listApi() {
        Map<Object, Object> data = Maps.builder().put("page", 1).put("size", 10).put("pageCount", 10).put("itemCount", 99).put("list", monitorService.listUnindexedSql()).build();
        return R.success(data);
    }

}
