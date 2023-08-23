package io.github.yaowenbin.charon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CharonApplication.class)
public class IntegrationTest extends Assertions {

    protected static final Logger log = LoggerFactory.getLogger(IntegrationTest.class);

    @Container
    protected static final MySQLContainer MY_SQL_CONTAINER =
            new MySQLContainer("mysql:8").withDatabaseName("charon").withUsername("root").withPassword("root");

    @Test
    void mysqlContainerRunning() {
        assertThat(MY_SQL_CONTAINER.isRunning()).isTrue();
        log.info("MYSQL_CONTAINER_MAPPING_PORT: {}", MY_SQL_CONTAINER.getMappedPort(3306));
    }

}
