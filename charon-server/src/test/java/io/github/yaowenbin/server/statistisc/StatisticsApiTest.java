package io.github.yaowenbin.server.statistisc;

import io.github.yaowenbin.server.SpringContextTest;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class StatisticsApiTest extends SpringContextTest {

    @Test
    void statisticsIndexApi() throws Exception {
        mvc.perform(get("/statistic/index"))
                .andDo(print())
                .andExpect(jsonPath("$.data.datasourceCount").isNumber())
                .andExpect(jsonPath("$.data.connectionCount").isNumber());
    }

}