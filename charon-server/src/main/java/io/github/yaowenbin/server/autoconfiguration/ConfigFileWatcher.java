package io.github.yaowenbin.server.autoconfiguration;


import io.github.yaowenbin.commons.file.FileWatcher;
import io.github.yaowenbin.commons.file.Files;
import io.github.yaowenbin.commons.string.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
@ConditionalOnProperty(prefix = "spring.config", name = "additional-location")
public class ConfigFileWatcher {

    @Value("${spring.config.additional-location}")
    public String additionalLocation;

    public FileWatcher fileWatcher;

    @Resource
    Environment environment;

    @Resource
    CharonConfigProperties charonConfigProperties;

    @Resource
    ApplicationEventPublisher publisher;

    @PostConstruct
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile(additionalLocation);

        fileWatcher = Files.watch(file.toPath(), (configPath) -> {
            try (InputStream inputStream = Files.newInputStream(configPath)) {
                CharonConfigProperties newConfig = new Yaml(new Constructor(CharonConfigProperties.class)).load(inputStream);

                charonConfigProperties.reloadFrom(newConfig);
                publisher.publishEvent(new ConfigRefreshEvent(this));
            } catch (IOException e) {
                throw new RuntimeException(Strings.format("cannot load config file from: {}", configPath.toAbsolutePath()));
            }
        });

    }

}
