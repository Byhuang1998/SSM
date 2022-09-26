package com.bylearning.spring.proxy;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 19:15
 * @description TODO
 */
public class CalculatorStaticProxy implements Calculator{

    private CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }
    /*
     * 静态代理：
     * 确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性
     * 拿日志功能来说，将来其他也需要附加日志，那还得再声明更多个静态代理类，会产生大量重复的代码
     * 日志功能也还是分散的，没有统一管理
     *
     * 进一步需求：将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理类来实现，这就需要使用动态代理技术
     */
    @Override
    public int add(int i, int j) {
        int result = 0;
        try {
            System.out.println("add function start...");
            result = target.add(i, j);
            System.out.println("add function finish...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("sub function start...");
        int result = target.sub(i, j);
        System.out.println("sub function finish...");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("mul function start...");
        int result = target.mul(i, j);
        System.out.println("mul function finish...");
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("div function start...");
        int result = target.div(i, j);
        System.out.println("div function finish...");
        return result;
    }
}
