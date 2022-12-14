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

    Emp getEmpById(@Param("id") Integer id);

    List<Emp> getEmpByDeptId(@Param("deptId") Integer deptId);

    Emp getEmpAndDept(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpIdStepOne(@Param("empId") Integer empId);
}
