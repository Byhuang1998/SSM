package com.bylearning.spring.controller;

import com.bylearning.spring.service.UserService;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 11:37
 * @description TODO
 */
public class UserController {

    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser() {
        userService.saveUser();
    }
}
