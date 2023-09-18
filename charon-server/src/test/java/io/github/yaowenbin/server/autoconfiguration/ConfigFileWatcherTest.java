package io.github.yaowenbin.server.autoconfiguration;

import io.github.yaowenbin.server.SpringContextTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


class ConfigFileWatcherTest extends SpringContextTest {

    @Resource
    ConfigFileWatcher watcher;

    @Test
    void shouldNotLoad_whenMissingSpringConfigAdditionalConfig() {
        assertThat(watcher).isNotNull();
    }

    @Value("${spring.config.additional-location}")
    public String additionalLocation;

    @Test
    void something() throws IOException {
        File file = ResourceUtils.getFile(additionalLocation);
        Constructor constructor = new Constructor(CharonConfigProperties.class);
        Yaml yaml = new Yaml(constructor);
        yaml.setBeanAccess(BeanAccess.FIELD);
        CharonConfigProperties fileProperties = yaml.load(new FileInputStream(file));

        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml dumpYaml = new Yaml(options);

        // try (FileWriter fileWriter = new FileWriter(file)){
        //     dumpYaml.dump(fileProperties, fileWriter);
        // }

        // assertThat(properties.getDatasource().get("db1").getUsername()).isEqualTo("changed");
    }

}
