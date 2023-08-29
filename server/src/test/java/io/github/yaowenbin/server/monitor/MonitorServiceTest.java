package io.github.yaowenbin.server.monitor;

import io.github.yaowenbin.charon.SpringContextTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class MonitorServiceTest extends SpringContextTest {

    @Resource
    MonitorService monitorService;

    @Test
    void listSqlWithoutIndexed() {
        List<UnindexedSql> result = monitorService.listUnindexedSql();
        log.info("result: {}", result);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
    }
}
