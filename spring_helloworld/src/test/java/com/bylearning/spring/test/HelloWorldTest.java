package com.bylearning.spring.test;

import com.bylearning.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/25 12:38
 * @description TODO
 */
public class HelloWorldTest {

    @Test
    public void test() {
        // 获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取IOC容器中的bean
        HelloWorld helloworld = (HelloWorld)ioc.getBean("hello-world");
        HelloWorld helloworld1 = (HelloWorld)ioc.getBean("hello-world");
        System.out.println(helloworld);
        System.out.println(helloworld1); // 两个地址相同，验证Spring窗器创建对象是单例模式
        helloworld.sayHello();
    }
}
