package com.learning.boot.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by topaz on 2017/7/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.learning.boot.web.controller"})
@Import(value = {DBConfig.class})
public class SpringMvcConfig {

}
