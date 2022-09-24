package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.EmpMapper;
import com.bylearning.mybatis.pojo.Emp;
import com.bylearning.mybatis.pojo.EmpExample;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/24 21:31
 * @description TODO
 */
public class MBGTest {

    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample example = new EmpExample();
        /**
         * 先通过createCriteria()方法构造一个查询条件，如果有多个条件要用或连接
         * 再用or()方法构造另一个或条件
         * 如下是查询年龄为20或年龄为22的员工
         */
        example.createCriteria().andAgeEqualTo(20);
        example.or().andAgeEqualTo(22);
        List<Emp> emps = mapper.selectByExample(example);
        System.out.println(emps);
        sqlSession.close();
    }
}
