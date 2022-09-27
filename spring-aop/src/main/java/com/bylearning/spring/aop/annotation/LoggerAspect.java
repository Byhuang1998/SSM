package com.bylearning.spring.aop.annotation;

import org.aopalliance.intercept.Joinpoint;
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
 * 1. 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知，在目标对象方法执行之前执行
 *
 * 2. 切入点表达式：设置在标识通知的注解的value属性中
 * execution(* com.bylearning.spring.aop.annotation.*.*(..))
 * 第一个 * 表示任意的访问修饰符和返回值类型
 * 第二个 * 表示任意的类
 * 第三个 * 表示任意的方法
 * ..表示任意的参数列表
 *
 * 3. 重用切入点表达式
 * @PointCut("execution(* com.bylearning.spring.aop.annotation.*.*(..))")
 *
 * 4. 获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应方法的信息
 *
 * 5. 切面的优先级
 * 可以通过@Order注解的value属性设置优先级，默认值Integer的最大值
 * @Order注解的value属性值越小，优先级越高
 */
@Component
@Aspect // 将当前组件标识为切面类
public class LoggerAspect {

    /**
     *  2. 切入点表达式：设置在标识通知的注解的value属性中
     *  execution(* com.bylearning.spring.aop.annotation.*.*(..))
     *  第一个 * 表示任意的访问修饰符和返回值类型
     *  第二个 * 表示任意的类
     *  第三个 * 表示任意的方法
     *  ..表示任意的参数列表
     */
    @Pointcut("execution(* com.bylearning.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {}

//    @Before("execution(* com.bylearning.spring.aop.annotation.*.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        // 获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        // 获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法：" + signature.getName() + "，参数：" + Arrays.toString(args));

    }

    @After("pointCut()")
    public void afterAdviceMethod() {
        System.out.println("LoggerAspect，后置通知");

    }

    /**
     * 在返回通知中若要获取目标对象的返回值
     * 只需要通过@AfterReturning注解的returning属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的返回值
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LoggerAspect，返回通知，方法名" + name + "，返回结果是：" + result);

    }

    /**
     * 在异常通知中若要获取目标对象的返回值
     * 只需要通过@AfterThrowing注解的throwing属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的抛出异常值
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) { // Exception e 或者 Throwable e
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("LoggerAspect，异常通知，方法名" + name + "，异常是：" + e);
    }

    /**
     * 在异常通知中若要获取目标对象的返回值
     * 只需要通过@AfterThrowing注解的throwing属性
     * 就可以将通知方法的某个参数指定为接收目标对象方法的抛出异常值
     */
    @Around(value = "pointCut()")
    public Object afterThrowingAdviceMethod(ProceedingJoinPoint proceedingJoinPoint) {
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
