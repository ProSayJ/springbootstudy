package com.prosayj.springboot.javase.homework.day03_a.com.dao.impl;

import com.prosayj.springboot.javase.homework.day03_a.com.dao.UserDBMapper;
import com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDB.UserDB;
import com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDoman;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:19
 * @since 1.0.0
 */
public class UserDBMapperImpl implements UserDBMapper {

    @Override
    public Boolean checkUser(UserDoman userDoman) {
        //初始化数据库
        UserDB userDB = new UserDB();
        // 获取数据库数据
        List<UserDoman> userData = userDB.getUserData();
        //处理数据
        for (UserDoman user : userData) {
            if (user.getUserName().equals(userDoman.getUserName()) && user.getPwd().equals(userDoman.getPwd())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
