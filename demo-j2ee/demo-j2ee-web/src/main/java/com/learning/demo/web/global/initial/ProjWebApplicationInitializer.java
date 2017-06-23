package com.learning.demo.web.global.initial;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

/**
 * Created by topaz on 2017/6/22.
 */
public class ProjWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
//        ServletRegistration.Dynamic registration = container.addServlet("example", new DispatcherServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/example/*");
    }
}
