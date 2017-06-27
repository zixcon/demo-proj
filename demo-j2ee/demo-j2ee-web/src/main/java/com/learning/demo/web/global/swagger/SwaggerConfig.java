package com.learning.demo.web.global.swagger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问Swagger的api列表页面
 * http://{ip}:{port}/{projectname}/swagger-ui.html#/
 *
 * 需要在spring mvc中配置启用，原因是配置类必须和mvc处于同一个上下文中
 * http://blog.csdn.net/qq_25615395/article/details/70229139
 *
 * Created by topaz on 2017/6/26.
 */
// @Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.learning.demo.web.controller"))//controller路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf(){
        return new ApiInfoBuilder()
                .title("demo-proj")
                .termsOfServiceUrl("http://blog.csdn.net/qq_25615395/article/details/70229139")
                .description("swagger2")
                .contact(new Contact("demo-proj", "http://127.0.0.1:8080/demo", "zixcon.fan@outlook.com"))
                .build();

    }
}
