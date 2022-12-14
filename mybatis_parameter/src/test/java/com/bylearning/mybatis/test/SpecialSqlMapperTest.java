package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.SpecialSqlMapper;
import com.bylearning.mybatis.pojo.User;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
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

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUser("4, 5");
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getAllUser("t_user");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "001", "123456", 33, "男", "12345@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }
}
