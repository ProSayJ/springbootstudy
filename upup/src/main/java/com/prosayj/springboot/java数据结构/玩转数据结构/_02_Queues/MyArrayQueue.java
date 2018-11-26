package com.prosayj.springboot.java数据结构.玩转数据结构._02_Queues;

import com.prosayj.springboot.java数据结构.玩转数据结构._00_Array.MyDynamicArray;

public class MyArrayQueue<E> implements MyQueue<E> {
    private MyDynamicArray<E> array;

    public MyArrayQueue(int capaticity) {
        array = new MyDynamicArray<E>(capaticity);
    }

    public MyArrayQueue() {
        array = new MyDynamicArray<E>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Queue: ");
        stringBuffer.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuffer.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("] tail");
        return stringBuffer.toString();
    }
}
