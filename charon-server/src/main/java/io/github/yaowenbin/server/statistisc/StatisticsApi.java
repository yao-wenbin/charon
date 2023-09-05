package io.github.yaowenbin.server.statistisc;

import io.github.yaowenbin.core.http.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatisticsApi {

    private final StatisticsQueryService service;

    @GetMapping("/statistic/index")
    R<StatisticsIndexDTO> statisticIndexApi() {
        return R.success(service.index());
    }

}
