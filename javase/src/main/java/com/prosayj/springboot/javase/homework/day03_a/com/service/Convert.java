package com.prosayj.springboot.javase.homework.day03_a.com.service;

import com.prosayj.springboot.javase.homework.day03_a.com.controller.vo.UserVO;
import com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDoman;
import com.prosayj.springboot.javase.homework.day03_a.com.service.Dto.UserDto;

/**
 * @author yangjian
 * @description 对象转换器
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:08
 * @since 1.0.0
 */
public class Convert {

    public static UserDto toUserDto(UserVO userVO) {
        return new UserDto(userVO.getUserName(), userVO.getPwd());
    }

    public static UserDoman toUserDoman(UserDto userDto) {
        return new UserDoman(userDto.getUserName(), userDto.getPwd());
    }
}
