package com.bylearning.spring.pojo;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/25 12:31
 * @description TODO
 */
public class HelloWorld {

    private HelloSpring helloSpring;

    public void sayHello() {
        helloSpring.sayHello();
    }

    public void setHelloSpring(HelloSpring helloSpring) {
        this.helloSpring = helloSpring;
    }
}
