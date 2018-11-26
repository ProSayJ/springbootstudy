package com.prosayj.springboot.java数据结构.玩转数据结构._02_Queues;

public interface MyQueue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 插入一个元素
     * @param e
     */
    void enqueue(E e);

    /**
     * 删除一个元素：队列
     * @return
     */
    E dequeue();

    /**
     * 获取一个元素
     * @return
     */
    E getFront();
}
