package com.bylearning.proxy;

import com.bylearning.spring.proxy.CalculatorImpl;
import com.bylearning.spring.proxy.CalculatorStaticProxy;
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
}
