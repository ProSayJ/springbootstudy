package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.compositereuse;

/**
 * @description mysql连接
 * @author yangjian
 * @Date 上午 01:44 2019/9/11
 * @since 1.0.0
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
