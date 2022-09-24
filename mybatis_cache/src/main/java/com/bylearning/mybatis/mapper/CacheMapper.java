package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/24 17:18
 * @description TODO
 */
public interface CacheMapper {

    Emp getEmpById(@Param("empId") Integer empId);

    void insertEmp(Emp emp);

}
