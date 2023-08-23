package io.github.yaowenbin.charon.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.charon.UnitTest;
import io.github.yaowenbin.charon.autoconfiguration.DataSourceProperty;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */
// @Testcontainers
class DataSourceCreatorTest extends UnitTest {

    // @Container
    // private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer();
    //
    // @Test
    // void mysqlContainerRunning() {
    //     assertThat(MY_SQL_CONTAINER.isRunning()).isTrue();
    // }

    @Test
    void create() throws SQLException {
        DataSourceProperty property = new DataSourceProperty().setLazy(true)
                .setUrl("jdbc:mysql://127.0.0.1:3306/charon")
                .setPassword("root")
                .setUsername("root");
        DataSourceCreator creator = new DataSourceCreator();

        DruidDataSource druid = (DruidDataSource) creator.create(property);

        assertThat(druid).isNotNull();
        assertThat(druid.getUsername()).isNotNull();
        assertThat(druid.getPassword()).isNotNull();
        assertThat(druid.getUrl()).isNotNull();

        assertThat(druid.getConnection(1000));
    }

}