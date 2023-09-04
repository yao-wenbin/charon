package io.github.yaowenbin.test;

import io.github.yaowenbin.server.CharonApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
@TestPropertySource(properties = {"spring.config.location= classpath:charon-conf.yml"})
@SpringBootTest(classes = CharonApplication.class)
@ExtendWith(SpringExtension.class)
public class SpringContextTest extends UnitTest {

}
