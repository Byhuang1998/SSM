package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.User;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/21 22:48
 * @description TODO
 */
public interface UserMapper {

    int insertUser();

    int updateUser();

    int deleteUser();

    User getUserById();

    List<User> getAllUsers();
}
