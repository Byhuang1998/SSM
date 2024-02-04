package com.bylearning.controller;

import com.bylearning.entity.User;
import com.bylearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 19:33
 * @description TODO
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String protal() {
        // 将逻辑视图返回
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println(userService);
        return "success";
    }

    @RequestMapping("/model")
    public ModelAndView model(ModelAndView modelAndView) {
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/http")
    public String model(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest);
        httpServletRequest.setAttribute("username", "zhangsan");
        return "success";
    }

    @RequestMapping("/return")
    @ResponseBody
    public String returnData() {
        return "return";
    }

    @RequestMapping("/user")
    @ResponseBody
    public User returnObject() {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(23);
        return user;
    }
}
