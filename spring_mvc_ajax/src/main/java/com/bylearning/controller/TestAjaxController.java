package com.bylearning.controller;

import com.bylearning.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/29 11:10
 * @description TODO
 * 1、@RequestBody：将请求体中的内容和控制器方法的形参进行绑定
 * 2、使用@RequestBody注解，将json格式的请求参数转换为java对象
 * a> 导入jackson的依赖
 * b> 在SpringMVC的配置文件中设置<mvc:annotation-driven/></mvc:annotation-driven>
 * c> 在处理请求的控制器方法的形参位置，直接设置json格式要转化成的java类类型形参，使用@RequestBody注解标识
 *
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public String testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody:" + requestBody);
        System.out.println("id:" + id);
        response.getWriter().write("hello, axios");
        return "success";
    }
    @RequestMapping("/test/RequestBody/json")
    public String testRequestBody(@RequestBody Map map, HttpServletResponse response) throws IOException {
        System.out.println("map:" + map);
        response.getWriter().write("hello, requestBody");
        return "success";
    }

    public String testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("user:" + user);
        response.getWriter().write("hello, requestBody");
        return "success";
    }
}
