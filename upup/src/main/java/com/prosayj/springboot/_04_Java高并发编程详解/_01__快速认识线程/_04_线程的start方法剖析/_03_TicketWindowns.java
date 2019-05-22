package com.prosayj.springboot._04_Java高并发编程详解._01__快速认识线程._04_线程的start方法剖析;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 11:36
 * @since 1.0.0
 */
public class _03_TicketWindowns extends Thread {
    //柜台名称
    private final String name;
    //最多受理50笔业务
    private static final int MAX = 50;

    private int index = 1;

    public _03_TicketWindowns(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        new _03_TicketWindowns("一号出号机器").start();
        new _03_TicketWindowns("二号出号机器").start();
        new _03_TicketWindowns("三号出号机器").start();
        new _03_TicketWindowns("四号出号机器").start();
    }
}
