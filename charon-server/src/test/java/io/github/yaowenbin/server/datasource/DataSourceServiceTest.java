package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.server.UnitTest;
import io.github.yaowenbin.server.autoconfiguration.properties.DataSourceMetaProperties;
import org.junit.jupiter.api.Test;

class DataSourceServiceTest extends UnitTest {

    DataSourceService service = new DataSourceService(DataSourceTestFixture.mockMultiDataSource());

    @Test
    void collection() {
        assertThat(service.collection()).isNotEmpty();
        DataSourceMetaProperties res = service.collection().stream().findFirst().get();

        assertThat(res.getUrl()).isEqualTo("jdbc:mysql://127.0.0.1:3306/charon");
        assertThat(res.getUsername()).isEqualTo("root");
        assertThat(res.getPassword()).isEqualTo("root");
    }
}