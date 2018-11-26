package com.prosayj.springboot.java数据结构.玩转数据结构._01_Stack;

import com.prosayj.springboot.java数据结构.玩转数据结构._00_Array.MyDynamicArray;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/14 21:09
 * @since 1.0.0
 */
public class MyArrayStack<E> implements MyStack<E> {

    private MyDynamicArray<E> myArray;

    public MyArrayStack() {
        myArray = new MyDynamicArray<E>();
    }

    public MyArrayStack(int capacity) {
        this.myArray = new MyDynamicArray<E>(capacity);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return myArray.getSize() == 0;
    }

    @Override
    public void push(E e) {
        myArray.addLast(e);
    }

    @Override
    public E pop() {
        return myArray.removeLast();
    }

    @Override
    public E peek() {
        return myArray.getLast();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack: [ ");
        for (int i = 0; i < myArray.getSize(); i++) {
            result.append(myArray.get(i));
            if (i != myArray.getSize() - 1) {
                result.append(", ");
            }
        }
        result.append(" ] <=== top");
        return result.toString();

    }

}
