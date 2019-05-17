package com.prosayj.springboot.designmode.研磨设计模式._11_observer._01;

/**
 * @author yangjian
 * @description 观察者  买牛奶的人观察送牛奶的人
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/29 23:40
 * @since 1.0.0
 */
public class Person {
    //订阅者
    private SendMilk sendMilk;

    public Person(SendMilk sendMilk) {
        this.sendMilk = sendMilk;
        //把自己记录到送牛奶的人的小本子上
        sendMilk.addPeople(this);
    }

    //被订阅者调用的方法，入被打电话
    public void phone(String message) {
        System.out.println(message);
    }
}
