package io.github.yaowenbin.charon.monitor;

import io.github.yaowenbin.charon.datasource.DataSourceHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class PerformanceSchemaQueryService {

    private final PerformanceSchemaMapper mapper;

    public List<UnindexedSql> listUnindexedSqlByDs(String dbKey) {
        DataSourceHolder.push(dbKey);
        // return mapper.listNoIndexUsedSql(NoIndexUsedSqlReq.EMPTY);
        return mapper.listNoIndexUsedSql();
    }

    public List<MysqlThread> listMysqlThreadByDs(String dbKey) {
        DataSourceHolder.push(dbKey);
        return mapper.listMysqlThread();
    }
}
