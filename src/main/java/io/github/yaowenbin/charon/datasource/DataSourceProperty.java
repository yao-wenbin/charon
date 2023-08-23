package io.github.yaowenbin.charon.datasource;

import lombok.Builder;
import lombok.Data;


/**
 * @Author yaowenbin
 * @Date 2023/8/17
 * Property to contain the yaml's object and then convert it to DataSource.
 *
 */
@Data
@Builder
public class DataSourceProperty {

    private String url;

    private String username;

    private String password;

    private Boolean lazy;

}
