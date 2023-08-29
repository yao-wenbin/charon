package io.github.yaowenbin.server.monitor;

import io.github.yaowenbin.server.SpringContextTest;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
class PerformanceSchemaQueryServiceTest extends SpringContextTest {

    @Resource
    PerformanceSchemaQueryService performanceSchemaQueryService;

    @Resource
    SqlSession sqlSession;

    public static final String testDbKey = "db1";

    @Test
    void listUnindexedSql() {
        List<UnindexedSql> result = performanceSchemaQueryService.listUnindexedSqlByDs(testDbKey);
        assertThat(result).hasSize(0);

        // for create a unindexed sql.
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        mapper.selectAll();

        result = performanceSchemaQueryService.listUnindexedSqlByDs(testDbKey);
        log.info("result: {}", result);
        assertThat(result).hasSizeGreaterThanOrEqualTo(1);
    }

    @Test
    void listMysqlThread() {
        List<MysqlThread> result = performanceSchemaQueryService.listMysqlThreadByDs(testDbKey);
        log.info("result: {}", result);
        assertThat(result).isNotNull();
    }



}