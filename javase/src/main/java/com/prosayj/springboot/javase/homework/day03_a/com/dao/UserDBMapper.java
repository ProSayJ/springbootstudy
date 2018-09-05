package com.prosayj.springboot.javase.homework.day03_a.com.dao;


import com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDoman;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 21:58
 * @since 1.0.0
 */
public interface UserDBMapper {

    Boolean checkUser(UserDoman userDoman);
}
