package com.bylearning.spring.service.impl;

import com.bylearning.spring.dao.BookDao;
import com.bylearning.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 12:20
 * @description TODO
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
//    @Transactional(
//            readOnly = true
//            timeout = 3
//            noRollbackFor = ArithmeticException.class 默认运行时异常会回滚
//            isolation = Isolation.DEFAULT
//            propagation = Propagation.REQUIRES_NEW
//    )
    public void buyBook(Integer userId, Integer bookId) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // query the price of the book
        Integer price = bookDao.getPriceByBookId(bookId);
        // update the stock of the book
        bookDao.updateStock(bookId);
        // update the balance of the user
        bookDao.updateBalance(userId, price);
//        System.out.println(1 / 0);
    }
}
