package com.prosayj.springboot.designmode.研磨设计模式._03_adapter.example1;

/**
 * @author yangjian
 * @description 使用适配器的客户端
 * @Date 17:54 2018/8/5
 * @since 1.0.0
 */

public class Client {
    public static void main(String[] args) {
        //创建需被适配的对象
        Adaptee adaptee = new Adaptee();
        //创建客户端需要调用的接口对象
        Target target = new Adapter(adaptee);
        //请求处理
        target.request();
    }
}

