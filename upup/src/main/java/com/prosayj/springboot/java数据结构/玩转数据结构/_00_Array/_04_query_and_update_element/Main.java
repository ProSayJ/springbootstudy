package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._04_query_and_update_element;

public class Main {

    public static void main(String[] args) {

        Array arr = new Array(20);
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
    }
}
