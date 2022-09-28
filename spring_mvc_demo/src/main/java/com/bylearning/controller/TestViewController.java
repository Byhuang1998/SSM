package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 15:58
 * @description TODO
 */
@Controller
public class TestViewController {

    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleafView() {
        return "success";
    }

    @RequestMapping("/test/view/forward")
    public String testInternalResourcesView() {
        return "forward:/test/model";
    }

    @RequestMapping("/test/view/redirect")
    public String testRedirectView() {
        return "redirect:/test/model";
    }
}
