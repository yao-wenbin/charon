package io.github.yaowenbin.charon.monitor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MonitorService {

    private final PerformanceSchemaMapper mapper;

    public List<UnindexedSql> listUnindexedSql() {
        return mapper.listNoIndexUsedSql(NoIndexUsedSqlReq.EMPTY);
    }
}
