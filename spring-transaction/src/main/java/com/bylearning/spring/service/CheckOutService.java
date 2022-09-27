package com.bylearning.spring.service;

/**
 * @author mskj-huangbingyi
 * @version 1.0
 * @data 2022/9/27 16:50
 * @description TODO
 */
public interface CheckOutService {

    public void checkOut(Integer userId, Integer[] bookIds);
}
