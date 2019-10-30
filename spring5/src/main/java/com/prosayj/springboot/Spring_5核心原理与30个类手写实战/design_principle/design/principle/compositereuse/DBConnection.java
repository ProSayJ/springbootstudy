package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.compositereuse;

/**
 * @author yangjian
 * @description 数据库连接
 * @Date 上午 01:43 2019/9/11
 * @since 1.0.0
 */
public abstract class DBConnection {
    //    public String getConnection(){
//        return "MySQL数据库连接";
//    }
    public abstract String getConnection();
}
