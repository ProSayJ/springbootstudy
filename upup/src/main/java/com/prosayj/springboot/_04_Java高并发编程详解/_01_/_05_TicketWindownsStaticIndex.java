package com.prosayj.springboot._04_Java高并发编程详解._01_;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 11:36
 * @since 1.0.0
 */
public class _05_TicketWindownsStaticIndex extends Thread {
    //柜台名称
    private final String name;
    //最多受理50笔业务
    private static final int MAX = 50;

    private static int index = 1;

    public _05_TicketWindownsStaticIndex(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        new _05_TicketWindownsStaticIndex("一号出号机器").start();
        new _05_TicketWindownsStaticIndex("二号出号机器").start();
        new _05_TicketWindownsStaticIndex("三号出号机器").start();
        new _05_TicketWindownsStaticIndex("四号出号机器").start();
    }
}
