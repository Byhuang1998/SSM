package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 15:13
 * @description TODO
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        /**
         * 1、通过ModelAndView向请求域共享数据
         * ModelAndView包含Model和View的功能
         * Model：向请求域中共享数据
         * View：设置逻辑视图，实现页面跳转，但是控制器方法一定要将ModelAndView作为返回值
         */
        ModelAndView mav = new ModelAndView();
        // 向请求域中共享数据
        mav.addObject("testRequestScope", "hello, ModelAndView");
        // 设置逻辑视图
        mav.setViewName("success");
        return mav;
    }
}
