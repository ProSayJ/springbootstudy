package com.prosayj.springboot.javase.homework.review.service;

import com.prosayj.springboot.javase.homework.review.service.model.UserDto;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 19:05
 * @since 1.0.0
 */
public interface IUserService {
    Boolean checkUser(UserDto userDto);
}
