package com.bylearning.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/30 10:35
 * @description TODO
 */
// 将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Throwable ex, Model model) {
        model.addAttribute("ex:" + ex);
        return "error";
    }
}
