package com.bylearning.spring.dao.impl;

import com.bylearning.spring.dao.UserDao;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 11:38
 * @description TODO
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
