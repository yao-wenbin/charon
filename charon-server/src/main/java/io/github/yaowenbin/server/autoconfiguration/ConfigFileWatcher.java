package io.github.yaowenbin.server.autoconfiguration;


import io.github.yaowenbin.commons.file.FileWatcher;
import io.github.yaowenbin.commons.file.Files;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;

public class ConfigFileWatcher {

    public ConfigFileWatcher(String additionalLocation) {
        File file = null;
        try {
             file = ResourceUtils.getFile(additionalLocation);
        } catch (FileNotFoundException ignore) {
        }
        FileWatcher fileWatcher = Files.watch(file.toPath(), (configPath) -> {
            System.out.println("fileChanged");
        });
    }


}
