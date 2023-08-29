package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.charon.UnitTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
class DataSourceHolderTest extends UnitTest {


    @Test
    void notNull() {
        assertThat(DataSourceHolder.peek()).isEqualTo("");

        DataSourceHolder.push("primary");
        assertThat(DataSourceHolder.peek()).isEqualTo("primary");

        DataSourceHolder.push("slave");
        assertThat(DataSourceHolder.peek()).isEqualTo("slave");

        DataSourceHolder.poll();
        assertThat(DataSourceHolder.peek()).isEqualTo("primary");

        DataSourceHolder.poll();
        assertThat(DataSourceHolder.peek()).isEqualTo("");

        DataSourceHolder.clear();
        /* ThreadLocal will when call get() method after remove() method*/
        assertDoesNotThrow(DataSourceHolder::peek);
    }




}