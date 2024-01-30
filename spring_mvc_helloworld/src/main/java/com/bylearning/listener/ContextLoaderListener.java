package com.bylearning.listener;

import com.bylearning.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener init...");
        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("ioc", ioc);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
