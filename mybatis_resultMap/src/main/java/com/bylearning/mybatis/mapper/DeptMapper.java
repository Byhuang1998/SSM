package com.bylearning.mybatis.mapper;

import com.bylearning.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/24 10:51
 * @description TODO
 */
public interface DeptMapper {

    Dept getDeptByDeptId(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpById(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpByStep(@Param("deptId") Integer deptId);
}
