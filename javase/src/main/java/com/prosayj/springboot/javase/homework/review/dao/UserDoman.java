package com.prosayj.springboot.javase.homework.review.dao;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/27 18:27
 * @since 1.0.0
 */
public class UserDoman {
    private String username;
    private String password;

    public UserDoman(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDoman{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
