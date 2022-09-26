package com.bylearning.spring.service.impl;

import com.bylearning.spring.dao.UserDao;
import com.bylearning.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 14:30
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl")
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
