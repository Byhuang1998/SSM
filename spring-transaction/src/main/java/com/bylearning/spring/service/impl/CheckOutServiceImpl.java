package com.bylearning.spring.service.impl;

import com.bylearning.spring.service.BookService;
import com.bylearning.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 16:50
 * @description TODO
 */
@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private BookService bookService;

    @Override
//    @Transactional
    public void checkOut(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(userId, bookId);
        }
    }

}
