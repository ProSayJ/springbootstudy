package com.prosayj.springboot.javase.homework.review.service;


import com.prosayj.springboot.javase.homework.review.controller.tools.Convert;
import com.prosayj.springboot.javase.homework.review.dao.UserDoman;
import com.prosayj.springboot.javase.homework.review.dao.UserMapper;
import com.prosayj.springboot.javase.homework.review.dao.UserMapperImpl;
import com.prosayj.springboot.javase.homework.review.service.model.UserDto;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 19:07
 * @since 1.0.0
 */
public class UserServiceImpl implements IUserService {
    @Override
    public Boolean checkUser(UserDto userDto) {

        UserDoman userDoman = Convert.toUserDoman(userDto);
        UserMapper userMapper = new UserMapperImpl();
        Boolean aBoolean = userMapper.checkUser(userDoman);
        if(aBoolean){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
        return aBoolean;
    }
}
