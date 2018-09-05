package com.prosayj.springboot.javase.homework.review.controller.tools;


import com.prosayj.springboot.javase.homework.review.controller.vo.UserVo;
import com.prosayj.springboot.javase.homework.review.dao.UserDoman;
import com.prosayj.springboot.javase.homework.review.service.model.UserDto;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 18:50
 * @since 1.0.0
 */
public class Convert {
   public static UserDto toUserDto(UserVo userVo){
       return new UserDto(userVo.getUsername(),userVo.getPassword());
   };

    public static UserDoman toUserDoman(UserDto userDto){
        return new UserDoman(userDto.getUsername(),userDto.getPassword());
    };
}
