package io.github.yaowenbin.server.core;

import io.github.yaowenbin.commons.string.Strings;

public class LoadConfigurationException extends RuntimeException{

    public LoadConfigurationException(String msg, Object... params) {
        super(Strings.format(msg, params));
    }

}
