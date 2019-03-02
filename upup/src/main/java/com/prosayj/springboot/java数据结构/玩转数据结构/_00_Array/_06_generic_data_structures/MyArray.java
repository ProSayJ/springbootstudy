package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._06_generic_data_structures;

/**
 * @author yangjian
 * @description 自定义数组
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 15:38
 * @since 1.0.0
 */
public class MyArray<E> {

    /**
     * 数组初始化容量
     */
    public static final int DEFAULY_CAPATICY = 10;

    /**
     * 内置数组
     */
    private E[] data;
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
//        data = new T[capacity];
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public MyArray() {
        this(DEFAULY_CAPATICY);
    }

    //获取方法：

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


    //添加方法

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index > size) {

        }
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. MyArray is full.");
        }
        if (index < 0 || index > size) {
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
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向所有元素后添加一个新元素
     */
    public void addList(E e) {
        add(size, e);
    }


    //修改

    /**
     * 修改index索引位置的元素为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 刪除索引是index的元素，并返回该元素，
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E result = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return result;
    }

    /**
     * 删除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定的元素，并返回元素存在的角标。若元素没有找到，返回-1
     *
     * @param e
     * @return
     */
    public int removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
        return index;
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
