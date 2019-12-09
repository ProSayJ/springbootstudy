package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._04_query_and_update_element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 18:50
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
//        myArray.add(2,5);
        myArray.addFirst(10);
        System.out.println(myArray);
        myArray.addList(5);
        System.out.println(myArray);
        myArray.addFirst(2);
        System.out.println(myArray);
//        myArray.set(3,98);
        System.out.println(myArray);

    }
}
