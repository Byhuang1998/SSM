package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.EmpMapper;
import com.bylearning.mybatis.pojo.Emp;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/23 18:25
 * @description TODO
 */
public class ResultMapTest {

    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
        sqlSession.close();
    }
}
