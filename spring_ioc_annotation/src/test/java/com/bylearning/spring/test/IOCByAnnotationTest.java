package com.bylearning.spring.test;

import com.bylearning.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 14:34
 * @description TODO
 */
public class IOCByAnnotationTest {

    /**
     * 通过注解+扫描所配置的bean的id，默认值为类的小驼峰，即类名的首字母为小写的结果
     * 可以通过标识组件的注解的value属性值来标识组件的id
     */

    @Test
    public void test() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController us = ioc.getBean("userController", UserController.class);
        System.out.println(us);
    }
}
