package io.github.yaowenbin.charon.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import io.github.yaowenbin.charon.IntegrationTest;
import io.github.yaowenbin.charon.autoconfiguration.DataSourceMetaProperties;
import org.junit.jupiter.api.Test;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */

class DataSourceCreatorTest extends IntegrationTest {

    @Test
    void create() {
        DataSourceMetaProperties property = new DataSourceMetaProperties().setLazy(false)
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