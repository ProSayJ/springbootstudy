package com.prosayj.springboot.spring_annotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//@Service
@Component(value = "userService2")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser() {
        userDao.insert();
        //otherDao.other();xxx
        System.out.println("插入完成...");
        int i = 10 / 0;
    }

}
