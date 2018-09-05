package com.prosayj.springboot.javase.homework.day03_a.com.service.Dto;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 22:12
 * @since 1.0.0
 */
public class UserDto {
    private String userName;
    private String pwd;

    public UserDto() {
    }

    public UserDto(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
