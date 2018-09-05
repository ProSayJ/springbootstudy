package com.prosayj.springboot.叶子猿java并发编程原理与实战._08_Atomic;

/**
 * @author yangjian
 * @description
 * @Date 23:14 2018/8/5
 * @since 1.0.0
 */
public class User {

    private String name;

    public volatile int old;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

}
