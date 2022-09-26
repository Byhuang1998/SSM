package com.bylearning.spring.proxy;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 18:48
 * @description TODO
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("function inner, result：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("function inner, result：" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("function inner, result：" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("function inner, result：" + result);
        return result;
    }
}
