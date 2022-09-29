package com.bylearning.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/29 17:06
 * @description TODO
 * ResponseEntity：可以作为控制器方法的返回值，表示响应到浏览器完整的响应报文
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        // 获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");
        realPath = realPath + File.separator + "lena.png";
        // 创建输入流
        InputStream is = new FileInputStream(realPath);
        // 创建字节数组
        byte[] bytes = new byte[is.available()];
        // 将流读到字节数组中
        is.read(bytes);
        // 创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置下载方式及下载文件名字
        headers.add("Content-Disposition", "attachment;filename=lena.png");
        // 设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        // 关闭输入流
        is.close();
        return responseEntity;
    }
}

