package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.server.UnitTest;
import io.github.yaowenbin.server.datasource.api.DataSourceMetaDTO;
import io.github.yaowenbin.server.datasource.core.DataSourceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

class DataSourceServiceTest extends UnitTest {

    DataSourceService service = new DataSourceService();

    @BeforeEach
    void setUp() {
        // service.setDataSource(DataSourceTestFixture.mockMultiDataSource());
    }

    @Test
    void collection() {
        Collection<DataSourceMetaDTO> res = service.collection();
        assertThat(res).isNotEmpty();
        DataSourceMetaDTO dataSourceMetaDTO = res.stream().findFirst().get();

        assertThat(dataSourceMetaDTO.getKey()).isEqualTo("db1");
        assertThat(dataSourceMetaDTO.getUrl()).isEqualTo("jdbc:mysql://127.0.0.1:3306/charon");
        assertThat(dataSourceMetaDTO.getUsername()).isEqualTo("root");
    }
}