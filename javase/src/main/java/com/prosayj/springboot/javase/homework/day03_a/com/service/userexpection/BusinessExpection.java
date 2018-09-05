package com.prosayj.springboot.javase.homework.day03_a.com.service.userexpection;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:33
 * @since 1.0.0
 */
public class BusinessExpection extends RuntimeException {
    public BusinessExpection(String message) {
        super(message);
    }
}
