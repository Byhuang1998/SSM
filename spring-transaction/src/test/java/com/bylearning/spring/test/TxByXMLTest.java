package com.bylearning.spring.test;

import com.bylearning.spring.controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 17:22
 * @description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
    }

    @Test
    public void testCheckOut() {
        bookController.checkOut(1, new Integer[]{1, 2});
    }
}
