package io.github.yaowenbin.charon.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.charon.IntegrationTest;
import io.github.yaowenbin.charon.autoconfiguration.DataSourceProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */

@ExtendWith(SpringExtension.class)
@Testcontainers
@Slf4j
class DataSourceCreatorTest extends IntegrationTest {

    @Test
    void create() {
        DataSourceProperty property = new DataSourceProperty().setLazy(false)
                .setUrl(MY_SQL_CONTAINER.getJdbcUrl())
                .setPassword("root")
                .setUsername("root");
        DataSourceCreator creator = new DataSourceCreator();

        DruidDataSource druid = (DruidDataSource) creator.create(property);

        assertThat(druid).isNotNull();
        assertThat(druid.getUsername()).isNotNull();
        assertThat(druid.getPassword()).isNotNull();
        assertThat(druid.getUrl()).isNotNull();
    }

}