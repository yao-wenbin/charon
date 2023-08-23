package io.github.yaowenbin.charon.datasource;

import java.sql.SQLException;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
public class InitDataSourceException extends RuntimeException {
    public InitDataSourceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
