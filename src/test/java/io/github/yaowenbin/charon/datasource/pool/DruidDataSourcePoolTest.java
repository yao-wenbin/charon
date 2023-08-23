package io.github.yaowenbin.charon.datasource.pool;

import io.github.yaowenbin.charon.UnitTest;
import io.github.yaowenbin.charon.datasource.pool.DataSourcePool;
import io.github.yaowenbin.charon.datasource.pool.DruidDataSourcePool;
import org.junit.jupiter.api.Test;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */
public class DruidDataSourcePoolTest extends UnitTest {

    @Test
    void allApi() {
        DataSourcePool pool = new DruidDataSourcePool();
        assertThat(pool.dataSourceMap()).isNotNull();

        // pool.addDataSource("test", new new);
    }

}
