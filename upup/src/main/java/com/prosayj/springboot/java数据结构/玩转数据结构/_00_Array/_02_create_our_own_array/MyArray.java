package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._02_create_our_own_array;

/**
 * @author yangjian
 * @description 自定义数组
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 15:38
 * @since 1.0.0
 */
public class MyArray {

    public static final int DEFAULY_CAPATICY = 10;

    /**
     * 内置数组
     */
    private int[] data;
    /**
     * 实际容量
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public MyArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public MyArray() {
        this(DEFAULY_CAPATICY);
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
