package io.github.yaowenbin.charon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CharonApplication.class)
@PropertySource(value = "classpath:/charon-conf.yml")
@Testcontainers
@ActiveProfiles("test")
public class IntegrationTest extends UnitTest {

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
