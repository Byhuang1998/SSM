package com.bylearning.controller;

import com.bylearning.config.SpringConfiguration;
import com.bylearning.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService us = ioc.getBean(UserService.class);
        us.saveUser();
    }
}
