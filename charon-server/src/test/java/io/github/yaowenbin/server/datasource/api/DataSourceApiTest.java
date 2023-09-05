package io.github.yaowenbin.server.datasource.api;

import io.github.yaowenbin.server.SpringContextTest;
import org.junit.jupiter.api.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DataSourceApiTest extends SpringContextTest {

    @Test
    void datasourcesApi() throws Exception {
        mvc.perform(get("/datasources"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].key").value("db1"))
                .andExpect(jsonPath("$.data[0].username").value("root"))
                .andExpect(jsonPath("$.data[0].url").value("jdbc:mysql://127.0.0.1:3306/charon"));
    }

}

