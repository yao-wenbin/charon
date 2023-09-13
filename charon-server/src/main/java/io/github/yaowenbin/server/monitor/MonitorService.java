package io.github.yaowenbin.server.monitor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public Collection<UnindexedSql> listUnindexedSql() {
        List<UnindexedSql> unindexedSqls = mapper.listNoIndexUsedSql();
        return unindexedSqls;
    }

    public Collection<MysqlThread> collectMysqlThreads() {
        return mapper.listMysqlThread();
    }
}
