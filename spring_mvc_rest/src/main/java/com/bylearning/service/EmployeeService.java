package com.bylearning.service;

import com.bylearning.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
