package com.bylearning.spring.pojo;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/25 12:31
 * @description TODO
 */
public class HelloWorld {

    public HelloWorld() {
        // 覆盖无参构造方法，是为了验证bean的scope分别为singleton和prototype时，创建对象的时机
        // 在Test代码中获取IoC容器那一行代码中打断点，执行测试方法
        // 当scope=singleton时，IoC容器完成加载时，对象就创建了
        // 当scope=prototype时，IoC容器完成加载时，还未创建对象，而是调用getBean方法时创建的
        System.out.println("object is creating...");
    }

    public void sayHello() {
        System.out.println("hello, spring");
    }
}
