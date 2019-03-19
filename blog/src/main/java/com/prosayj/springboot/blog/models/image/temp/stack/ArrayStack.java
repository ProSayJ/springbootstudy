package com.prosayj.springboot.blog.models.image.temp.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        } else if (initialCapacity == 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            this.elementData = new Object[initialCapacity];
        }

    }

    public E push(E e) {
        checkCapacity(size + 1);
        elementData[size++] = e;
        return e;
    }


    public E pop() {
        int len = size;
        if (len == 0) {
            throw new EmptyStackException();
        }
        E e = peek();
        elementData[--size] = null;
        return e;

    }

    public E peek() {
        int len = size;
        if (len == 0) {
            throw new EmptyStackException();
        }

        return (E) elementData[--len];

    }

    public boolean empty() {
        return this.size == 0;
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

    public int size() {
        return size;
    }
}
