package com.bylearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 17:10
 * @description TODO
 * 查询所有的用户信息 -->/user --> get
 * 根据id查询用户信息 -->/user/1 --> get
 * 添加用户信息 -->/user --> post
 * 修改用户信息 -->/user --> put
 * 查询所有的用户信息 -->/user --> get
 * 删除用户信息 -->/user/1 --> delete
 *
 * 注意：浏览器目前只能发送get和post请求
 * 若要发送put delete请求，需要在web.xml中配置一个过滤器HiddenHttpMethodFilter
 * 配置了过滤器后，发送的请求要满足两个条件，才能将请求方式转换为put delete
 * 1、当前请求为post
 * 2、当前请求必须传输参数_method
 */
@Controller
@RequestMapping("/user")
public class TestRestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有的用户信息 -->/user --> get");
        return "success";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询用户信息 -->/user/" + id + "--> get");
        System.out.println("用户id是：" + id);
        return "success";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("添加用户信息 -->/user --> post");
        return "success";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updateUser() {
        System.out.println("修改用户信息 -->/user --> put");
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteuser(@PathVariable("id") Integer id) {
        System.out.println("删除用户信息 -->/user/" + id + "--> delete");
        return "success";
    }
}
