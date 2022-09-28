package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 20:58
 * @description TODO
 * 1、@RequestMapping标识的位置
 * 可以标识一个类，设置映射请求的请求路径的初始信息
 * 可以标识一个方法，设置映射请求的请求路径的具体信息
 * 2、@RequestMapping注解value属性
 * 作用：通过请求的请求路径匹配请求
 * value属性是数组类型，即当前浏览器所发送请求的请求路径，来匹配value属性中的任何一个值
 * 则当前请求就会被注解所标识的方法进行处理
 * 3、method属性：通过请求的请求方式匹配请求，数组形式
 * 若浏览器所发送的请求的请求路径和@RequestMapping注释value属性匹配，但是请求方式不匹配，
 * 此时页面报错405
 * 在@RequestMapping的基础上，结合请求方式的一些派生注解：
 * @GetMapping, @PostMapping, @DeleteMapping, @PutMapping 分别只能匹配某一种请求方式的请求
 * 4、params属性
 * 作用：通过请求的请求参数匹配请求，即浏览器发送的请求的请求参数必须满足params属性的设置
 * params可以使用4种表达式：
 * "param"：表示当前所匹配请求的请求参数中必须携带param参数
 * "!param"：表示当前所匹配请求的请求参数中不能携带param参数
 * "param = value"：表示当前所匹配请求的请求参数中必须携带param参数且值必须为value
 * "param != value"：表示当前所匹配请求的请求参数中可以不携带param参数，若携带不能是value
 * 5、headers属性
 * 作用：通过请求的请求头信息匹配请求，即浏览器发送的请求的请求头信息必须满足headers属性的设置
 * 若浏览器所发送的请求的请求路径和value相匹配，但是请求头信息不匹配，报404
 * 6、SpringMVC支持ant风格的路径
 * 在value属性值中设置一些特殊字符
 * ?：任意的单个字符，不包括?
 * *：任意个数的任意字符，不包括?和/
 * **：任意层数的任意目录，注意使用方式只能写在在双斜线中，前后不能有任何字符
 * 7、使用路径中的占位符
 * 传统：/deleteUser?id=1
 * rest：/user/delete/1
 * 需要在value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 * 通过@PathVariable注解，将占位符所标识的值和控制器方法的形参进行绑定
 */
@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    // 此时控制器方法所匹配的请求的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello", "/abc"},
            method = {RequestMethod.POST},
            params = {"!password", "age = 20"},
            headers = {"referer"}
    )
    public String hello() {
        return "success";
    }

    @RequestMapping(value = "/a*a/test/ant")
    public String testAnt() {
        return "success";
    }

    @RequestMapping(value = "/test/rest/{id}/{username}")
    public String testRest(@PathVariable Integer id, @PathVariable String username) {
        System.out.println("id is " + id + ", username is " + username);
        return "success";
    }
}
