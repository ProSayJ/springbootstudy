package com.prosayj.springboot._04_Java高并发编程详解._01__快速认识线程._05_Runnable接口的引入以及策略模式在Thread中的使用;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 11:36
 * @since 1.0.0
 */
public class _03_TicketWindownsStaticIndex implements Runnable{
    //柜台名称
    private  String name;
    //最多受理50笔业务
    private final int MAX = 50;

    private static int index = 1;

    public _03_TicketWindownsStaticIndex() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前的号码是：" + (index++));
        }
    }
    public static void main(String[] args) {
        _03_TicketWindownsStaticIndex ticketWindownsStaticIndex = new _03_TicketWindownsStaticIndex();
        ticketWindownsStaticIndex.setName("一号出号机器");
        new Thread(ticketWindownsStaticIndex).start();
        ticketWindownsStaticIndex.setName("二号出号机器");
        new Thread(ticketWindownsStaticIndex).start();
        ticketWindownsStaticIndex.setName("三号出号机器");
        new Thread(ticketWindownsStaticIndex).start();
        ticketWindownsStaticIndex.setName("四号出号机器");
        new Thread(ticketWindownsStaticIndex).start();

    }
}