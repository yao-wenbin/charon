package io.github.yaowenbin.charon.core;

import io.github.yaowenbin.charon.UnitTest;
import io.github.yaowenbin.charon.core.Times;
import org.junit.jupiter.api.Test;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
class TimesTest extends UnitTest {

    @Test
    void str2Mills() {
        assertThat(Times.strToMills("30s")).isEqualTo(30000);
    }

}