package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.SpecialSqlMapper;
import com.bylearning.mybatis.pojo.User;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/23 16:12
 * @description TODO
 */
public class SpecialSqlMapperTest {

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
        sqlSession.close();
    }
}
