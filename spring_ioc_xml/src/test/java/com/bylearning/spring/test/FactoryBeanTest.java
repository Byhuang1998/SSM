package com.bylearning.spring.test;

import com.bylearning.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 11:20
 * @description TODO
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
