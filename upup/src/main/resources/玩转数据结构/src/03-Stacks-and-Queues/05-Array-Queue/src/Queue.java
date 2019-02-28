package com.prosayj.springboot.java数据结构.玩转数据结构.src

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
