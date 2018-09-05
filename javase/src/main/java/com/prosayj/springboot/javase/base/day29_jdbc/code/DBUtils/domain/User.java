package com.prosayj.springboot.javase.base.day29_jdbc.code.DBUtils.domain;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/5/18 16:00
 * @since 1.0.0
 */
public class User {
    private Long id;
    private String name;
    private String trueName;
    private String password;

    public User(Long id, String name, String trueName, String password) {
        this.id = id;
        this.name = name;
        this.trueName = trueName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trueName='" + trueName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
