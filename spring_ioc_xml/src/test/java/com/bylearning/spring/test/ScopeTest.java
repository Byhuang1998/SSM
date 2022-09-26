package com.bylearning.spring.test;

import com.bylearning.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 10:20
 * @description TODO
 */
public class ScopeTest {

    @Test
    public void testScope() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student s1 = ioc.getBean(Student.class);
        Student s2 = ioc.getBean(Student.class);
        System.out.println(s1 == s2);
    }
}
