package com.prosayj.springboot.springbootstudy.webrestfulcrud.exception;

public class UserNotException extends RuntimeException {

    public UserNotException(){
        super("用户不存在");
    }
}
