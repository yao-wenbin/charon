package io.github.yaowenbin.charon.monitor;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
@Mapper
public interface PerformanceSchemaMapper {

    List<UnindexedSql> listNoIndexUsedSql(NoIndexUsedSqlReq param);

    Long count();
}
