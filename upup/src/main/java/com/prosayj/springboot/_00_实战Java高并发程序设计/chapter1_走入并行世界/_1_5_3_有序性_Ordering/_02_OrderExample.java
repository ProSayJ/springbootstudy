package com.prosayj.springboot._00_实战Java高并发程序设计.chapter1_走入并行世界._1_5_3_有序性_Ordering;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/6/29 0:05
 * @since 1.0.0
 */
public class _02_OrderExample {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }
    public void reader() {
        if (flag) {
            int i = a + 1;//10
        }
    }
}