package com.bylearning.spring.dao;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 12:21
 * @description TODO
 */
public interface BookDao {

    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId, Integer price);
}
