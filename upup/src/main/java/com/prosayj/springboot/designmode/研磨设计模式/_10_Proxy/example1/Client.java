package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy.example1;

import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();
        Collection<UserModel> col = userManager.getUserByDepId("0101");
        System.out.println(col);
    }
}