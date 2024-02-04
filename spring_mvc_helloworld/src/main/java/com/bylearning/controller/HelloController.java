package com.bylearning.controller;

import com.bylearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
