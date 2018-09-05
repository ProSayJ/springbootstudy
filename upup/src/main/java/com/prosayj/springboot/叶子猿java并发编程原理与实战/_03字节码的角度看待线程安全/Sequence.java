package com.prosayj.springboot.叶子猿java并发编程原理与实战._03字节码的角度看待线程安全;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/8/1 23:28
 * @since 1.0.0
 */
class Sequence {
    private int value;

    public int getNext() {
        return value++;
    }
}
