package com.bylearning.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/26 23:57
 * @description TODO
 *
 */
@Component
@Aspect
@Order(value = 1)
public class ValidateAspect {

    @Pointcut("execution(* com.bylearning.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void beforeMethod() {
        System.out.println("ValidateAspect --> 前置通知");
    }

}
