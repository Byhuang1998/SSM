package com.bylearning.spring.factory;

import com.bylearning.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

import javax.jws.soap.SOAPBinding;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 11:17
 * @description TODO
 * FactoryBean是一个接口，需要创建一个类来实现该接口
 * 其中有三个方法
 * getObject()：通过一个对象交给IOC容器管理
 * getObjectType()：设置所提供对象的类型
 * isSingleton()：所提供的对象是否为单例
 * 当把FactoryBean的实现类配置为一个实现类时，会将当前类中getObject()所返回的对象交给IOC容器管理
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
