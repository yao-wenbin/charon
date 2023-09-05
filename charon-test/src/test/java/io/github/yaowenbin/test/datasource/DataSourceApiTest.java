package io.github.yaowenbin.test.datasource;

import io.github.yaowenbin.test.SpringContextTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
public class DataSourceApiTest extends SpringContextTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void collection() throws Exception {
        mvc.perform(get("/datasources"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.datasource.db1.url").value("jdbc:mysql://127.0.0.1:3306/charon"));
    }

}
