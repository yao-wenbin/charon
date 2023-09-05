package io.github.yaowenbin.server.datasource;

import io.github.yaowenbin.commons.string.Strings;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class DataSourceException extends RuntimeException {
    public DataSourceException(String msg) {
        super(msg);
    }
    public DataSourceException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataSourceException(String msg, Object... args) {
        super(Strings.format(msg, args));
    }
}
