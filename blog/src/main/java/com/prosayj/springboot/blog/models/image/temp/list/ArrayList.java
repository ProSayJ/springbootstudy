package com.prosayj.springboot.blog.models.image.temp.list;

import java.util.Arrays;

/**
 * @author wang.xw
 * @date 2018/2/13 10:27.
 */
public class ArrayList<T> {
    /**
     * 默认的初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 记录数组容量的大小
     */
    private int size;
    /**
     * 默认的一个长度为0的数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * 存储数据的数组
     */
    private Object[] elementData;

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * <li>写代码的时一定要注意代码的健壮性,和异常的处理</>
     *
     * @param initCapacity
     */
    public ArrayList(int initCapacity) {
        if (initCapacity > 0) {
            this.elementData = new Object[initCapacity];
        } else if (initCapacity == 0) {
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("initCapacity size no < 0" + initCapacity);
        }
    }

    /**
     * @return 数组的长度也是ArraryList的长度
     */
    public int size() {
        return this.size;
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     * <li> 添加元素的时候我们必须考虑的数组的容量的问题，如果数组容量不够就需要增加数组的容量</>
     *
     * @param t
     * @return
     */
    public boolean add(T t) {
        checkCapacity(size + 1);
        this.elementData[size++] = t;
        return true;
    }

    /**
     * 添加元素在指定的位置
     *
     * @param index
     * @param t
     */
    public boolean add(int index, T t) {
        checkIndex(index);
        checkCapacity(size + 1);
        fastAdd(index);
        elementData[index] = t;
        size++;
        return true;
    }

    private void fastAdd(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    /**
     * 检查数组容量并扩容
     *
     * @param minCapacity
     */
    private void checkCapacity(int minCapacity) {
        int newCapacity = 0;
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        if (minCapacity - elementData.length > 0) {
            newCapacity = minCapacity + minCapacity >> 1;
            newCapacity = newCapacity > Integer.MAX_VALUE ? Integer.MAX_VALUE : newCapacity;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

    }


    /**
     * 根据索引删除
     * <li>检查索引是否合法</>
     * <li>删除原素之后的元素需要向前移动</>
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        fastRemove(index);
        size--;
        return (T) elementData[index];
    }

    private void fastRemove(int index) {
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    /**
     * 删除原素
     * <li> t是否为null</>
     *
     * @param t
     * @return
     */
    public boolean remove(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i].equals(t)) {
                    fastRemove(i);
                    return true;
                }
            }
        }

        size--;
        return false;
    }

    /**
     * 索引角标越界检查
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index - size > 0 || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    /**
     * 替换第index位置的元素
     *
     * @param t
     * @param index
     * @return
     */
    public boolean replace(int index, T t) {
        elementData[index] = t;
        return true;
    }

    /**
     * 获取第index位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        checkIndex(index);
        return (T) elementData[index];
    }
}
