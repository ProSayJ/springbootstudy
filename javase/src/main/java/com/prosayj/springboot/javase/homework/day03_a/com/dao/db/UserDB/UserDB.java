package com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDB;

import com.prosayj.springboot.javase.homework.day03_a.com.dao.db.UserDoman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 21:59
 * @since 1.0.0
 */
public class UserDB {
    private List<UserDoman> userData = new ArrayList<>();

    public List<UserDoman> getUserData() {
        return userData;
    }

    public UserDB() {
        userData.add(new UserDoman("zhangsan", "123"));
        userData.add(new UserDoman("lisi", "456"));
    }
}
