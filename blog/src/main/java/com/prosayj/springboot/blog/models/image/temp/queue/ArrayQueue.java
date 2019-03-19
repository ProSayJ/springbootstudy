package com.prosayj.springboot.blog.models.image.temp.queue;

import exception.EmptyQueueException;

import java.util.Arrays;

/**
 * @author wang.xw
 * @date 2018/8/6 16:20.
 */
public class ArrayQueue<E> implements Queue<E> {
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            this.elementData = new Object[initialCapacity];
        }

    }

    private void checkCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);

        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public boolean offer(E e) {
        checkCapacity(size + 1);
        this.elementData[size++] = e;
        return true;
    }

    public E poll() {
        E e = peek();
        for (int i = 0; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return e;
    }

    public E peek() {
        if (size == 0)
            throw new EmptyQueueException();
        return (E) this.elementData[0];
    }
}
