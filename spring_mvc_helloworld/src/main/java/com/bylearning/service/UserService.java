package com.bylearning.service;

import com.bylearning.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser() {
        userDao.save();
    }
}
