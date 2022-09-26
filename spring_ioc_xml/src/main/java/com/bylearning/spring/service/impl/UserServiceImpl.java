package com.bylearning.spring.service.impl;

import com.bylearning.spring.dao.UserDao;
import com.bylearning.spring.service.UserService;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 11:39
 * @description TODO
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
