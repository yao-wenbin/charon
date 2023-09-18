package io.github.yaowenbin.server.autoconfiguration;

import org.springframework.beans.factory.annotation.Value;


public class ConfigFileWatcher {

    @Value("spring.config.additional-location")
    String configPath;

    public ConfigFileWatcher() {
        // Path path = Path.of(configPath);
        // Files.watch(path, (configPath) -> {
        //
        // });
    }


}
