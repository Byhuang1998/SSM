package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    /**
     * 2、通过Model向请求域共享数据
     * 3、通过ModelMap向请求域共享数据
     * 4、通过Map向请求域共享数据
     * 5、其实在底层，三者最终都通过BindAwareModelMap创建
     */
    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello, Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello, Model");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String, Object> map) {
        map.put("testRequestScope", "hello, Model");
        return "success";
    }
}
