package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._03_add_element_in_array;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 16:19
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        System.out.println(myArray);
        myArray.addFirst(9);
        myArray.addList(3);
        System.out.println(myArray);
        myArray.add(1,99);
        System.out.println(myArray);
        myArray.addFirst(100);
        myArray.addList(100);
        System.out.println(myArray);

    }
}
