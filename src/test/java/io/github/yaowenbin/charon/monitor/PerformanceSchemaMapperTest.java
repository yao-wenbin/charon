package io.github.yaowenbin.charon.monitor;

import io.github.yaowenbin.charon.SpringContextTest;
import io.github.yaowenbin.charon.datasource.DataSourceHolder;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class PerformanceSchemaMapperTest extends SpringContextTest {

    @Resource
    PerformanceSchemaMapper mapper;

    @Test
    void ListUnindexedSql() {
        DataSourceHolder.push("db1");
        List<UnindexedSql> result = mapper.listNoIndexUsedSql(NoIndexUsedSqlReq.EMPTY);
        log.info("listUnindexedSql result: {}", result);
        assertThat(result).isNotNull();
    }

    @Test
    void count() {
        mapper.count();
    }


}
