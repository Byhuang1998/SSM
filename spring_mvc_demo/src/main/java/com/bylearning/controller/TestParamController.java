package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 10:33
 * @description TODO
 * 获取请求参数的方式
 * 1、只需要在控制器方法的形参位置设置HttpServletRequest类型的形参，就可以在控制器方法
 * 使用request对象获取请求参数
 * 2、通过控制器方法的形参获取
 * 只需要在控制器形参的位置设置形参，但是要保持形参名称和传递过来的请求参数名相同
 * 3、@RequestParam注解将请求参数和控制器方法的形参绑定
 * 三个属性：value, required, defaultValue
 * 4、@RequestHeader：将请求头信息和控制器方法的形参绑定
 * 4、@CookieValue：将cookie数据和控制器方法的形参绑定
 */
@Controller
public class TestParamController {

    @RequestMapping(value = "/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ", password:" + password);
        return "success";
    }

    @RequestMapping(value = "/param")
    public String getParam(
            @RequestParam(value = "username", required = false, defaultValue = "hello") String userName,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId) {
        System.out.println("username:" + userName + ", password:" + password);
        System.out.println("referer:" + referer);
        System.out.println("jsessionId:" + jsessionId);
        return "success";
    }
}
