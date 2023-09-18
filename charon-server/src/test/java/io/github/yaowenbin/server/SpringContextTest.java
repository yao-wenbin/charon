package io.github.yaowenbin.server;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration Test with Spring Context and Mock MVC.
 */
@TestPropertySource(properties = {"spring.config.additional-location=classpath:charon-conf.yml"})
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class SpringContextTest extends UnitTest {

    @Autowired
    protected MockMvc mvc;

}
