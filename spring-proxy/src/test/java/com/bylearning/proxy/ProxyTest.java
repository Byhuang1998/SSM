package com.bylearning.proxy;

import com.bylearning.spring.proxy.Calculator;
import com.bylearning.spring.proxy.CalculatorImpl;
import com.bylearning.spring.proxy.CalculatorStaticProxy;
import com.bylearning.spring.proxy.ProxyFactory;
import org.junit.Test;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 19:19
 * @description TODO
 */
public class ProxyTest {

    @Test
    public void testProxy() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        int result = proxy.add(1, 1);
        System.out.println(result);
    }

    /**
     * 动态代理有两种：
     * 1. jdk动态代理，要求必须有接口，最终生成的代理类在com.sun.proxy包下，类名为$proxy7
     * 2. cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
     */
    @Test
    public void testDynamicProxy() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1, 1);
    }
}
