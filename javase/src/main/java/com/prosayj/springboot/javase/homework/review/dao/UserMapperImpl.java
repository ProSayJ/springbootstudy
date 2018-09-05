package com.prosayj.springboot.javase.homework.review.dao;

import com.prosayj.springboot.javase.homework.review.dao.db.UserDB;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 19:21
 * @since 1.0.0
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public Boolean checkUser(UserDoman userDoman) {
        UserDB userDB = new UserDB();
        List<UserDoman> userData = userDB.getUserData();
        for (UserDoman user:userData) {
            if(user.getUsername().equals(userDoman.getUsername()) && user.getPassword().equals(userDoman.getPassword())){
                return true;
            }
        }
        return false;
    }
}
