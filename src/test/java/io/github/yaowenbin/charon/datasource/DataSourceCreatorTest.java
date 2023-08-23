package io.github.yaowenbin.charon.datasource;

import io.github.yaowenbin.charon.UnitTest;
import io.github.yaowenbin.charon.datasource.DataSourceCreator;
import io.github.yaowenbin.charon.datasource.DataSourceProperty;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

/**
 * @Author yaowenbin
 * @Date 2023/8/22
 */
class DataSourceCreatorTest extends UnitTest {

    @Test
    void toDataSource() {
        DataSourceProperty property = DataSourceProperty.builder().lazy(false).url("127.0.0.1").password("root").username("root").build();
        DataSourceCreator creator = new DataSourceCreator();
        DataSource ds = creator.create(property);
        assertThat(ds).isNotNull();
    }

}