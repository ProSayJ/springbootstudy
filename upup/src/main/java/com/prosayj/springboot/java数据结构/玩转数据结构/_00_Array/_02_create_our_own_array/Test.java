package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._02_create_our_own_array;
/**
 * @author yangjian
 * @description 自定义数组
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 15:41
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        System.out.println(myArray.isEmpty());
        System.out.println(myArray.getSize());
        System.out.println(myArray.getCapacity());
    }
}
