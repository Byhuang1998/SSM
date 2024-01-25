package com.bylearning;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {

    public static ApplicationContext getWebApplicationContext(ServletContext servletContext) {
        ApplicationContext ioc = (ApplicationContext) servletContext.getAttribute("ioc");
        return ioc;
    }
}
