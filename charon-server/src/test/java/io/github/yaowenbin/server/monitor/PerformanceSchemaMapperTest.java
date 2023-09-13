package io.github.yaowenbin.server.monitor;

import io.github.yaowenbin.server.SpringContextTest;
import io.github.yaowenbin.server.datasource.core.DataSourceHolder;
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
        List<UnindexedSql> result = mapper.listNoIndexUsedSql();
        // var result = mapper.listMysqlThread();
        log.info("listUnindexedSql result: {}", result);
        assertThat(result).isNotNull();
        assertThat(result).element(0).isNotNull();
    }


}
