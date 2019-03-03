package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array;

import com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._07_dynamic_array.MyArray;

public class MainTest {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>(4);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for (int i = 0; i < 4; i++) {
            arr.removeFirst();
            System.out.println(arr);
        }
    }
}
