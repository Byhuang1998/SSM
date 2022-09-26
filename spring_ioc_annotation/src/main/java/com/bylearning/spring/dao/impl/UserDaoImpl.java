package com.bylearning.spring.dao.impl;

import com.bylearning.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 14:31
 * @description TODO
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser() {
        System.out.println("save successfully");
    }
}
