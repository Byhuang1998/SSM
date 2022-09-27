package com.bylearning.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 21:02
 * @description TODO
 */
@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法：" + signature.getName() + "，参数：" + Arrays.toString(args));

    }

    public void afterAdviceMethod() {
        System.out.println("LoggerAspect，后置通知");

    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LoggerAspect，返回通知，方法名" + name + "，返回结果是：" + result);

    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) { // Exception e 或者 Throwable e
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LoggerAspect，异常通知，方法名" + name + "，异常是：" + e);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        try {
            System.out.println("环绕通知 --> 前置通知位置");
            // 表示目标对象方法的执行
            result = proceedingJoinPoint.proceed();
            System.out.println("环绕通知 --> 返回通知位置");
        } catch (Throwable e) {
            System.out.println("环绕通知 --> 异常通知位置");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知 --> 后置通知位置");
        }
        return result;
    }
}
