package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.DynamicSQLMapper;
import com.bylearning.mybatis.pojo.Emp;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/24 14:41
 * @description TODO
 */
public class DynamicMapperTest {

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 20, "");
        List<Emp> emps = mapper.getEmpByCondition(emp);
        System.out.println(emps);
        sqlSession.close();
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 20, "");
        List<Emp> emps = mapper.getEmpByChoose(emp);
        System.out.println(emps);
        sqlSession.close();
    }

    @Test
    public void testInsertMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "张三", 20, "男");
        Emp emp2 = new Emp(null, "李四", 20, "男");
        Emp emp3 = new Emp(null, "王五", 20, "男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = {5, 6, 7};
        mapper.deleteMoreEmp(empIds);
        sqlSession.close();
    }
}
