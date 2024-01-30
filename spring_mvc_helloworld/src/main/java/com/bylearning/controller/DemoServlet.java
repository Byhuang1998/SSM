package com.bylearning.controller;

import com.bylearning.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        UserService us = ioc.getBean(UserService.class);
        us.saveUser();
    }
}
