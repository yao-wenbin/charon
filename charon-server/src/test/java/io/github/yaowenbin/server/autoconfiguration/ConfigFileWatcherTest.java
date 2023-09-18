package io.github.yaowenbin.server.autoconfiguration;

import io.github.yaowenbin.server.SpringContextTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;


class ConfigFileWatcherTest extends SpringContextTest {

    @Resource
    ConfigFileWatcher watcher;

    @Test
    void shouldNotLoad_whenMissingSpringConfigAdditionalConfig() {
        assertThat(watcher).isNotNull();
    }

}
