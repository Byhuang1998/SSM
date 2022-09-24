package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.CacheMapper;
import com.bylearning.mybatis.pojo.Emp;
import com.bylearning.mybatis.utils.SqlSessionUtil;
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
 * @data 2022/9/24 17:24
 * @description TODO
 */
public class CacheMapperTest {

    /**
    * @author mskj-huangbingyi
    * @date: 2022/9/24 18:01
    * @param: []
    * @return: void
    * @description: TODO
    */
    @Test
    public void testGtEmpById() {
        /**
         * Mybatis的一级缓存：
         * sqlSession级别的，即通过同一个sqlSession查询的数据会被缓存
         * 查询相同的内容不会重新执行sql去数据库里查询，而是去缓存中获取
         *
         * 使一级缓存失效的4种情况：
         * 1. 不同的sqlSession对应不同的一级缓存
         * 2. 同一个sqlSession但查询条件不同
         * 3. 同一个sqlSession两次查询期间执行了任何一次增删改查操作
         * 4. 同一个sqlSession两次查询期间手动清空了缓存
         *
         * MyBatis的二级缓存：
         * MyBatis的二级缓存是sqlSessionFactory级别的，即通过同一个sqlSessionFactory获取的sqlSession对象查询的数据会被缓存
         * 在通过同一个sqlSessionFactory所获取的sqlSession查询相同的数据会从缓存中获取
         * MyBatis二级缓存开户的条件：
         * a. 在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
         * b. 在映射文件中设置标签<cache/>
         * c. 二级缓存必须在sqlSession关闭或提交之后有效
         * d. 查询的数据所转换的实体类型必须实现序列化接口
         *
         * 使二级缓存失效的1种情况：
         * 1. 同一个sqlSessionFactory下的sqlSession对象两次查询期间执行了任何一次增删改查操作，即增删改会令一级、二级缓存都失效
         * 2. 值得注意的是，sqlSession。clearCache()不会清空二级缓存，只会清空一级缓存
         */
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);
        sqlSession.close();
    }

    @Test
    public void testGtEmpByIdMidInsert() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        mapper.insertEmp(new Emp(null, "赵六", 26, "男"));

        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
        sqlSession.close();
    }

    @Test
    public void testGtEmpByIdClearCache() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        sqlSession.clearCache();

        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
        sqlSession.close();
    }

    /**
    * @author mskj-huangbingyi
    * @date: 2022/9/24 17:48
    * @param: []
    * @return: void
    * @description: 测试二级缓存
    */
    @Test
    public void testSecondCache() {
        try {
            // 具体注释见MyBatisTest.java方法
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp1 = mapper.getEmpById(1);
            System.out.println(emp1);
            sqlSession.close();

            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp2 = mapper1.getEmpById(1);
            System.out.println(emp2);
            sqlSession1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
