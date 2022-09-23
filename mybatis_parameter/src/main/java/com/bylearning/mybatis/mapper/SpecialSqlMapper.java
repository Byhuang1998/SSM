package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/23 16:09
 * @description TODO
 */
public interface SpecialSqlMapper {

    List<User> getUserByLike(@Param("mohu") String mohu);

    void deleteMoreUser(@Param("ids") String ids);

    List<User> getAllUser(@Param("tablename") String tablename);
}
