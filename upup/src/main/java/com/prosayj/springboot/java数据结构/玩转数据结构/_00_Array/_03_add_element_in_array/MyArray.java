package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._03_add_element_in_array;

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


    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. MyArray is full.");
        }
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;

    }

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向所有元素后添加一个新元素
     */
    public void addList(int e) {
        add(size, e);
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(String.format("MyArray Capacity-is 【%d】,size-is【%d】：[", data.length, size));
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                result.append(data[i]).append(",");
            } else if (i == size - 1) {
                result.append(data[i]);
            } else {
                result.append(data[i]).append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}
