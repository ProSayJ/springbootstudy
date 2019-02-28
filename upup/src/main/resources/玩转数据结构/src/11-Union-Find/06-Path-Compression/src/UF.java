package com.prosayj.springboot.java数据结构.玩转数据结构.src

public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
