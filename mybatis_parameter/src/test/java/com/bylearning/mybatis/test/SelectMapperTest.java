package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.SelectMapper;
import com.bylearning.mybatis.pojo.User;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/23 15:12
 * @description TODO
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(3);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer cnt = mapper.getCount();
        System.out.println(cnt);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(3);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> list = mapper.getAllUserToMap();
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testGetAllUserToMapFunc2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMapFunc2();
        System.out.println(map);
        sqlSession.close();
    }
}
