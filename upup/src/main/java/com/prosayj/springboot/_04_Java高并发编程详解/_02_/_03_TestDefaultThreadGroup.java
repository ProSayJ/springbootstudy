package com.prosayj.springboot._04_Java高并发编程详解._02_;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 14:45
 * @since 1.0.0
 */
public class _03_TestDefaultThreadGroup {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        ThreadGroup testGroup = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(testGroup, "t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("mian thread blong group :" + mainThreadGroup.getName());

        System.out.println("t1 and mian thread blong the same group :" + (mainThreadGroup == t1.getThreadGroup()));

        System.out.println("t2 thread not blong the same group :" + (mainThreadGroup == t2.getThreadGroup()));

        System.out.println("t2 thread blong the main testGroup :" + (testGroup == t2.getThreadGroup()));


    }
}
