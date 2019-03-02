package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._05_contain_find_and_remove;

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
        myArray.addFirst(10);
        myArray.addList(5);
        myArray.addFirst(2);
        System.out.println(myArray);

//        System.out.println(myArray.find(10));
//        System.out.println(myArray.find(6));

        /*
        System.out.println(myArray.remove(0));
        System.out.println(myArray);
        System.out.println(myArray.remove(0));
        System.out.println(myArray);
        System.out.println(myArray.remove(0));
        System.out.println(myArray);
        System.out.println(myArray.remove(0));
        */

        /*
        System.out.println(myArray.removeFirst());
        System.out.println(myArray);
        System.out.println(myArray.removeLast());
        System.out.println(myArray);
        System.out.println(myArray.removeLast());
        */

        System.out.println(myArray.removeElement(2));
        System.out.println(myArray);
        System.out.println(myArray.removeElement(5));
        System.out.println(myArray);


    }
}
