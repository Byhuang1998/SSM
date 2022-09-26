package com.bylearning.spring.test;

import com.bylearning.spring.pojo.Student;
import com.bylearning.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 10:39
 * @description TODO
 */
public class LifeCycleTest {
    /**
     * 1. 实例化
     * 2. 依赖注入
     * 3. 后置处理器的postProcessBeforeInitialization
     * 4. 初始化，需要通过bean的init-method属性指定初始化的方法
     * 5. 后置处理器的postProcessAfterInitialization
     * 6. 销毁（在ioc窗口关闭的时候销毁） 需要通过bean的destroy-method属性指定销毁的方法
     *
     * 注意：
     * 若bean的作用域为单例时，生命步骤的前三个步骤会在获取IOC时执行
     * 若bean的作用域为多例时，生命步骤的前三个步骤会在获取bean时执行
     */

    @Test
    public void test() {
        // ConfigurableApplicationContext是ApplicationContest的子接口，扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        ioc.close();
        System.out.println(user);
    }
}
