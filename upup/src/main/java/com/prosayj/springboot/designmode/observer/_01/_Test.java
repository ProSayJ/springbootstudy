package com.prosayj.springboot.designmode.observer._01;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/29 23:48
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {

        SendMilk sendMilk = new SendMilk();


        Person p1 = new Person(sendMilk);
        Person p2 = new Person(sendMilk);
        Person p3 = new Person(sendMilk);
        Person p4 = new Person(sendMilk);
        Person p5 = new Person(sendMilk);

        sendMilk.sendMike();
    }
}
