package com.learning.boot.web;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBootWebApplication.class, args);
        SpringApplication app = new SpringApplication(DemoBootWebApplication.class);
        // http://patorjk.com/software/taag
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
