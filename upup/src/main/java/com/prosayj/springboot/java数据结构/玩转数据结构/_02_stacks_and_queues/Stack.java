package com.prosayj.springboot.java数据结构.玩转数据结构._02_stacks_and_queues;

public interface Stack<E> {
    /**
     * 获取栈内数据大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 压栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 弹栈
     *
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return
     */
    E peek();
}
