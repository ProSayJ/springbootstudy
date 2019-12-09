package com.prosayj.springboot.java数据结构.玩转数据结构._02_stacks_and_queues;

public class MyArrayStack<E> implements Stack<E> {

    private MyArray myArray;

    public MyArrayStack(int capacity) {
        myArray = new MyArray<>(capacity);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
