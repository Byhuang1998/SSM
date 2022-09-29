package com.bylearning.controller;

import com.bylearning.pojo.Employee;
import com.bylearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        Collection<Employee> employees = employeeService.getAllEmployee();
        // 将所有的员工信息在请求域中共享
        model.addAttribute("employees", employees);
//        return "employee_list";
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeService.save(employee);
        // 重新访问列表功能
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        // 根据id查询员工信息
        Employee employee = employeeService.get(id);
        // 将员工信息共享到请求域中
        model.addAttribute("employee", employee);
        // 跳转到employut_update页面
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        employeeService.save(employee);
        // 重新访问列表功能
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        // 重新访问列表功能
        return "redirect:/employee";
    }
}
