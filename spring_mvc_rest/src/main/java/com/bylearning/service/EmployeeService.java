package com.bylearning.service;

import com.bylearning.dao.EmployeeDao;
import com.bylearning.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/28 18:52
 * @description TODO
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Collection<Employee> getAllEmployee() {
        return employeeDao.getAll();
    }

    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    public Employee get(Integer id) {
        return employeeDao.get(id);
    }
}
