package com.bylearning.mybatis.test;

import com.bylearning.mybatis.mapper.EmpMapper;
import com.bylearning.mybatis.pojo.Emp;
import com.bylearning.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/24 22:19
 * @description TODO
 */
public class PageTest {

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 查询功能前开启分页功能
        Page<Emp> page = PageHelper.startPage(3, 4);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
        list.forEach(System.out::println);
        System.out.println(page);
        System.out.println(pageInfo);
    }
}
