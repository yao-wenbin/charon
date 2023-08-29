package io.github.yaowenbin.server.monitor;

import lombok.AccessLevel;
import lombok.Setter;

public class NoIndexUsedSqlReq {

    private Long threadId;
    private String currentSchema;
    @Setter(AccessLevel.NONE)
    private Long execTimeNs;
    @Setter(AccessLevel.NONE)
    private Long execTimeMs;

    private static final long NS2MS = 1000000;

    public void setExecTimeMs(Long execTimeNs) {
        this.execTimeMs = execTimeNs;
        this.execTimeNs = execTimeNs * NS2MS;
    }

    public static NoIndexUsedSqlReq EMPTY = new NoIndexUsedSqlReq();
}