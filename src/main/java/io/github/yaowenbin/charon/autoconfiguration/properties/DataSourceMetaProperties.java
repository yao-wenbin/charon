package io.github.yaowenbin.charon.autoconfiguration.properties;

import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @Author yaowenbin
 * @Date 2023/8/17
 * Property to contain the yaml's object and then convert it to DataSource.
 *
 */
@Data
@Accessors(chain = true)
public class DataSourceMetaProperties {

    private String url;

    private String username;

    private String password;

    private Boolean lazy;

}
