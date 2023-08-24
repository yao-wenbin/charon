package io.github.yaowenbin.charon.monitor;

import lombok.Data;

/**
 * @Author yaowenbin
 * @Date 2023/8/25
 */
@Data
public class MysqlThread {

    private Long threadId;
    private Long processListId;
    private Long osThreadId;
    private String user;
    private String host;
    private String db;
    private String command;
    private Long time;
    private String state;
    private String connectionType;

}
