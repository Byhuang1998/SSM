package com.bylearning.controller;

import com.bylearning.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("springmvc.xml");
        UserService us = ioc.getBean(UserService.class);
        us.saveUser();
    }
}
