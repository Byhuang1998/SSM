package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/24 14:34
 * @description TODO
 */
public interface DynamicSQLMapper {

    List<Emp> getEmpByCondition(Emp emp);

    List<Emp> getEmpByChoose(Emp emp);

    void insertMoreEmp(List<Emp> emps);

    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
