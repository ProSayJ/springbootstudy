package com.prosayj.springboot.designmode.研磨设计模式._04_singleton.example4;

public class Client {
    public static void main(String[] args) {
        //创建读取应用配置的对象
        AppConfig config = AppConfig.getInstance();

        String paramA = config.getParameterA();
        String paramB = config.getParameterB();

        System.out.println("paramA=" + paramA + ",paramB=" + paramB);
    }
}
