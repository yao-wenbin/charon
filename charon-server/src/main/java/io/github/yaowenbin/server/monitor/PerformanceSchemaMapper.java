package io.github.yaowenbin.server.monitor;

import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public interface PerformanceSchemaMapper {

    List<UnindexedSql> listNoIndexUsedSql();

    List<UnindexedSql> listNoIndexUsedSql(NoIndexUsedSqlReq param);

    List<MysqlThread> listMysqlThread();
}
