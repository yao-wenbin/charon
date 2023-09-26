package io.github.yaowenbin.server.alert.alerter;

import lombok.Data;

import java.util.Date;

@Data
public class AlerterMessage {

    private String dbName;

    private String message;

    private Date createTime;
}
