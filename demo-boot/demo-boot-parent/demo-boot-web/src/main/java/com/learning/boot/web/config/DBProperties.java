package com.learning.boot.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by topaz on 2017/7/20.
 */
@ConfigurationProperties(prefix = "mysql.datasource")
@Data
public class DBProperties {

    private String url;
    private String username;
    private String password;

}
