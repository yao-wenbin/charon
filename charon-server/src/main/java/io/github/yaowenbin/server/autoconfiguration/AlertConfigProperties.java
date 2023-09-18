package io.github.yaowenbin.server.autoconfiguration;


import lombok.Data;

@Data
public class AlertConfigProperties {

    private String name;

    private Type type;

    private String email;

    static enum Type {
        EMAIL
    }


}
