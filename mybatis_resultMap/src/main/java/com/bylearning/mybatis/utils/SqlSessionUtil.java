package com.bylearning.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/22 16:42
 * @description 获取SqlSession对象工具类
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession() {

        SqlSession sqlSession;
        try {
            // 具体注释见MyBatisTest.java方法
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }

}
