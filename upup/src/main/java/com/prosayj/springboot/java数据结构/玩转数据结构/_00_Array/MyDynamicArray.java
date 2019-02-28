package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/12 22:40
 * @since 1.0.0
 */
public class MyDynamicArray<E> {
    public static final int defaultSize = 10;

    /**
     * 有效的数组元素大小
     */
    private int size;
    /**
     * 集合元素
     */
    private E[] data;

    public MyDynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public MyDynamicArray() {
        this(defaultSize);
    }

    /**
     * 获取数组元素的大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否是空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index的位置插入一个新的元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild, require index > 0= or index <=size!");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 获取指定的角标元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild, Index illegal!");
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return data[0];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild, Index illegal!");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add faild, Index illegal!");
        }
        E result = data[index];
        //当前待移除的元素后面的元素都要后移
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("MyArray:size = %d, capacity = %d ==>", size, data.length));
        result.append("[ ");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        return result.append(" ]").toString();
    }

    /**
     * 数组扩容
     * @param newCapaticy
     */
    private void resize(int newCapaticy) {
        E[] newData = (E[]) new Object[newCapaticy];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
