package io.github.yaowenbin.server.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author yaowenbin
 * @Date 2023/8/21
 */
public class Files {

    public static void string2File(String str, File file) throws IOException {
        string2File(str, file.getAbsolutePath());
    }

    public static void string2File(String str, String filename) throws IOException {
        File file = new File(filename);
        File fileParent = file.getParentFile();
        if (fileParent != null) {
            fileParent.mkdirs();
        }

        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(str.getBytes(StandardCharsets.UTF_8));
        } finally {
            if (null != os) {
                os.close();
            }
        }
    }

}
