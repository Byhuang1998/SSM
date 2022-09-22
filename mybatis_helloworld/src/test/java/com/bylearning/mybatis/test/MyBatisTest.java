package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.UserMapper;
import com.bylearning.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/21 22:59
 * @description TODO
 */
public class MyBatisTest {

    @Test
    public void testInsertUser() throws IOException {
        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        // 获取Sql的会话对象sqlSession，是MyBatis提供操作的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取UserMapper的代理实现类对象（代理模式，创建了一个UserMapper的实现类）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 调用mapper接口中的方法，实现添加用户的功能
        int result = userMapper.insertUser();
        System.out.println("结果：" + result);

        /*
        提供sql以及的唯一标识找到sql并执行，唯一标识是namespace.sqlId，这种方法不常用，会有硬编码。
        int anotherResult = sqlSession.insert("com.bylearning.mybatis.mapper.UserMapper.insertUser");
        System.out.println(anotherResult);
        */

        // 提交事务，否则数据库会回滚 如果此前的openSession()方法里加上参数true，就会自动提交不需要手动commit了
//        sqlSession.commit();

        // 关闭session
        sqlSession.close();
    }
}
