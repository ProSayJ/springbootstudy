package com.prosayj.springboot.javase.homework.review.dao.db;


import com.prosayj.springboot.javase.homework.review.dao.UserDoman;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 18:30
 * @since 1.0.0
 */
public class UserDB {
     private List<UserDoman> userData= new ArrayList<>();

    public List<UserDoman> getUserData() {
        return userData;
    }


    public UserDB() {
        userData.add(new UserDoman("zhangsan","123"));
        userData.add(new UserDoman("lisi","456"));

    }
}
