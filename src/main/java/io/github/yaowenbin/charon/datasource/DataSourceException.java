package io.github.yaowenbin.charon.datasource;

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
}
