package com.bylearning.spring.test;

import com.bylearning.spring.pojo.Clazz;
import com.bylearning.spring.pojo.Person;
import com.bylearning.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/25 14:48
 * @description TODO
 */
public class IOCByXMLTest {

    /**
     * 获取bean的三种方式：
     * 1. 根据bean的id获取
     * 2. 根据bean的类型获取
     * 注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     * 若没有任何一个类型匹配的bean，此时抛出异常NoSuchBeanDefinitionException
     * 若有多个类型匹配的bean，此时抛出异常NoUniqueBeanDefinitionException
     * 3. 根据bean的id和类型来获取
     *
     * 结论：
     * 根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：对象 instanceOf 指定的类型
     * 如果是true，就可以认为和类型匹配，能够获取到
     * 即通过bean的类型，bean所继承的类型，所实现的接口都可以用于获取bean
     */

    @Test
    public void testIOC() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ioc.getBean("student7", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDI() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz clazz = ioc.getBean("clazz2", Clazz.class);
        System.out.println(clazz);
    }
}
