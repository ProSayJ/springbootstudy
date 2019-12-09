package com.prosayj.springboot.java数据结构.玩转数据结构.src

public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
