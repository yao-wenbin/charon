package io.github.yaowenbin.server.monitor;

import lombok.Data;

import java.util.Date;

@Data
public class Metric {

    private String name;

    private Integer type;

    private Date createTime;

    private Long val;

}
