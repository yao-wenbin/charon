package io.github.yaowenbin.server.autoconfiguration;

import org.springframework.context.ApplicationEvent;

public class ConfigRefreshEvent extends ApplicationEvent {

    public ConfigRefreshEvent(Object source) {
        super(source);
    }

}
