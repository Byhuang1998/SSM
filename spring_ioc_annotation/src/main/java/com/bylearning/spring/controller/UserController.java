package com.bylearning.spring.controller;

import com.bylearning.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 14:28
 * @description TODO
 */
@Controller
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    public void saveUser() {
        userService.saveUser();
    }
}
