package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/29 19:41
 * @description TODO
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String testHello() {
        System.out.println(1 / 0);
        return "success";
    }
}
