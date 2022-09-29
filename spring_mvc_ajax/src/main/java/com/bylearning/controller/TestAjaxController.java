package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/29 11:10
 * @description TODO
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public String testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        response.getWriter().write("hello, axios");
        return "success";
    }
}
