package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/23 18:22
 * @description TODO
 */
public interface EmpMapper {

    Emp getEmpByIdFunc1(@Param("id") Integer id);

    Emp getEmpById(@Param("id") Integer id);
}
