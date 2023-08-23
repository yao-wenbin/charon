package io.github.yaowenbin.charon.monitor;

import io.github.yaowenbin.charon.IntegrationTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class PerformanceSchemaMapperTest extends IntegrationTest {

    @Resource
    PerformanceSchemaMapper mapper;

    @Test
    void ListUnindexedSql() {
        List<UnindexedSql> result = mapper.listNoIndexUsedSql(NoIndexUsedSqlReq.EMPTY);

        assertThat(result).isNotNull();
    }


}
