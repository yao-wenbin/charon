package io.github.yaowenbin.charon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Author yaowenbin
 * @Date 2023/8/24
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class SpringContextTest extends UnitTest{

    @Test
    void loadContext() {

    }

}
