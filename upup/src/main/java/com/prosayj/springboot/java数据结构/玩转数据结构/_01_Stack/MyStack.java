package com.prosayj.springboot.java数据结构.玩转数据结构._01_Stack;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/14 21:06
 * @since 1.0.0
 */
public interface MyStack<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    /**
     * 看栈顶元素
     */
    E peek();
}
