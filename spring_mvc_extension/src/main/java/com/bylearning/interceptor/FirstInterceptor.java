package com.bylearning.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/29 19:49
 * @description TODO
 * preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截或放行
 * postHandle()：在控制器方法执行之后执行
 * afterCompletion()：在控制器方法执行之后，且渲染视图完毕之后执行
 *
 * 多个拦截器执行顺序和在SpringMVC的配置文件中配置的顺序有关
 * preHandle()按照配置的顺序执行，postHandle和afterCompletion按配置顺序反序执行
 *
 * 若拦截器中有某个拦截器的preHandle()返回了false：暂时略过
 * 锻炼看源码的能力
 **/
@Component
public class FirstInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor --> preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor --> postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor --> afterCompletion");
    }
}
