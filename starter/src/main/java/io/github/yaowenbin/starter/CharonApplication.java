package io.github.yaowenbin.starter;

import io.github.yaowenbin.starter.core.Configuration;
import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author yaowenbin
 * @Date 2023/8/17
 */
@SpringBootApplication
public class CharonApplication {
    public static void main(String... args) throws Exception {
        beforeRunning(args);
        SpringApplication.run(CharonApplication.class, args);
    }

    private static void beforeRunning(String[] args) throws IOException {
        String configPath = searchConfigPath(args);
        if (Strings.isBlank(configPath) || !Files.exists(Paths.get(configPath))) {
            throw new RuntimeException("Please create a config file");
        }

        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(configPath)));
        Configuration configuration = new Yaml().loadAs(bis, Configuration.class);


    }

    private static String searchConfigPath(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-c")) {
                return args[i + 1];
            }
        }
        return null;
    }
}
