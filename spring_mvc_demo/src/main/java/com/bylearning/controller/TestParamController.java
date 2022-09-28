package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 10:33
 * @description TODO
 * 获取请求参数的方式
 * 1、只需要在控制器方法的形参位置设置HttpServletRequest类型的形参，就可以在控制器方法
 * 使用request对象获取请求参数
 */
@Controller
public class TestParamController {

    @RequestMapping(value = "/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ", password:" + password);
        return "success";
    }
}
