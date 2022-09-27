package com.bylearning.spring.controller;

import com.bylearning.spring.service.BookService;
import com.bylearning.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 12:20
 * @description TODO
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckOutService checkOutService;

    public void buyBook(Integer userId, Integer bookId) {
        bookService.buyBook(userId, bookId);
    }

    public void checkOut(Integer userId, Integer[] bookIds) {
        checkOutService.checkOut(userId, bookIds);
    }
}
