package io.github.yaowenbin.server.monitor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @Author yaowenbin
 * @Date 2023/8/23
 */
@Data
public class UnindexedSql {

    private Long threadId;
    private String sqlText;
    private String currentSchema;
    @Setter(AccessLevel.NONE)
    private Long execTimeNs;
    @Setter(AccessLevel.NONE)
    private Long execTimeMs;
    private Long noIndexUsed;

    private static final long NS2MS = 1000000;

    public void setExecTimeNs(Long execTimeNs) {
        this.execTimeNs = execTimeNs;
        this.execTimeMs = execTimeNs / NS2MS;
    }

    public void setExecTimeMs(Long execTimeMs) {
        this.execTimeMs = execTimeMs;
        this.execTimeNs = execTimeMs * NS2MS;
    }

}
