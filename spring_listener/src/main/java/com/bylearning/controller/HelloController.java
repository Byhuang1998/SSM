package com.bylearning.controller;

import com.bylearning.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/30 16:06
 * @description TODO
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;
}
