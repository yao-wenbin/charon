package io.github.yaowenbin.server;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@Testcontainers
public class IntegrationTest extends SpringContextTest {

    @Container
    protected static final JdbcDatabaseContainer MY_SQL_CONTAINER =
            new MySQLContainer("mysql:8")
                    .withInitScript("sql/init.sql")
                    .withDatabaseName("charon")
                    .withUsername("root")
                    .withPassword("root");

    @Test
    void mysqlContainerRunning() {
        assertThat(MY_SQL_CONTAINER.isRunning()).isTrue();
        log.info("MYSQL_CONTAINER_MAPPING_PORT: {}", MY_SQL_CONTAINER.getMappedPort(3306));
    }

}
