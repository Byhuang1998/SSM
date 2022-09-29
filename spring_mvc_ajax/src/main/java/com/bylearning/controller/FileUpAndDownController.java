package com.bylearning.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/29 17:06
 * @description TODO
 * ResponseEntity：可以作为控制器方法的返回值，表示响应到浏览器完整的响应报文
 *
 * 文件上传的要求：
 * 1、form表单的请求方式必须为post
 * 2、form表单必须设置属性enctype="multipart/form-data"
 */
@Controller
public class FileUpAndDownController {

    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo, HttpSession session) throws IOException {
        String filename = photo.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 获取uuid
        String uuid = UUID.randomUUID().toString();
        filename = uuid + suffixName;
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + filename;
        // 上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }

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


