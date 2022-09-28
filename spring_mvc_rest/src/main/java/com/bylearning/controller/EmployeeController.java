package com.bylearning.controller;

import com.bylearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 18:52
 * @description TODO
 * 查询所有的用户信息 -->/employee --> get
 * 跳转到添加页面 -->/to/add --> get
 * 添加员工信息 -->/employee --> post
 * 跳转到修改页面 -->/employee/1 --> get
 * 修改用户信息 -->/employee --> put
 * 删除用户信息 -->/employee/1 --> delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



}
