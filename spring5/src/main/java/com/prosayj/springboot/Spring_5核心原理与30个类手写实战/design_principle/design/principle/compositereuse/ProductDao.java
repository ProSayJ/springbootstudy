package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.compositereuse;

/**
 * @author yangjian
 * @description
 * @Date 上午 01:45 2019/9/11
 * @since 1.0.0
 */
public class ProductDao {
    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct() {
        String conn = dbConnection.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }
}
