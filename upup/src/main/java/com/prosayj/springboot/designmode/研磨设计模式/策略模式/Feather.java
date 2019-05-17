package com.prosayj.springboot.designmode.研磨设计模式.策略模式;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/17 17:47
 * @since 1.0.0
 */
public class Feather implements Persion {
    @Override
    public void eat() {
        System.out.println("父亲吃饭");
    }
}
