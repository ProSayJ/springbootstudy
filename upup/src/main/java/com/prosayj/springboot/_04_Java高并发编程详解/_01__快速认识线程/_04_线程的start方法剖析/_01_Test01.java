package com.prosayj.springboot._04_Java高并发编程详解._01__快速认识线程._04_线程的start方法剖析;

import org.junit.Test;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/22 12:41
 * @since 1.0.0
 */
public class _01_Test01 {
    @Test
    public void m1() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
