package com.prosayj.springboot.javase.homework.day03_a.com.service;


import com.prosayj.springboot.javase.homework.day03_a.com.service.Dto.UserDto;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:10
 * @since 1.0.0
 */
public interface UserService {
    Boolean login(UserDto userDto, int loginTimes);
}
