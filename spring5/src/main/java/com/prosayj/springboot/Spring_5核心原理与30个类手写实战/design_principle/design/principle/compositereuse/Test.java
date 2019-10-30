package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.compositereuse;
/**
 * @description
 * @author yangjian
 * @Date 上午 01:45 2019/9/11
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new OracleConnection());
        productDao.addProduct();
    }

}
