package com.prosayj.springboot.multithread.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/18 21:03
 * @since 1.0.0
 */
public class _TestAtomicBoolean {
    public static void main(String[] args) {
        //无参默认为false
        AtomicBoolean a1 = new AtomicBoolean();
        System.out.println(a1.get());
        //有参显示设置
        AtomicBoolean a2 = new AtomicBoolean(Boolean.TRUE);
        AtomicBoolean a3 = new AtomicBoolean(Boolean.FALSE);
        System.out.println(a2.get());
        System.out.println(a3.get());

        AtomicBoolean a5 = new AtomicBoolean();
        //compareAndSet(boolean expect, boolean update); 期望的值和expect相同 就跟新为update
        System.out.println("a5-compareAndSetr(Boolean.FALSE, Boolean.TRUE)==>" + a5.compareAndSet(Boolean.FALSE, Boolean.TRUE));
//        System.err.println("a4-compareAndSetr(Boolean.FALSE, Boolean.FALSE)==>" + a4.compareAndSet(Boolean.FALSE, Boolean.FALSE));//特例

        AtomicBoolean a6 = new AtomicBoolean();
        a6.set(Boolean.TRUE);
        System.out.println("a6==>" + a6.toString());

        AtomicBoolean a7 = new AtomicBoolean();
        a7.getAndSet(Boolean.TRUE);
        System.out.println("a7==>" + a7.toString());

        AtomicBoolean a8 = new AtomicBoolean();
        a8.lazySet(Boolean.TRUE);
        a8.set(Boolean.FALSE);
        System.out.println("a8==>" + a8.toString());

    }
}
