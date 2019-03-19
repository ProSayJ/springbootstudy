package com.prosayj.springboot.blog.models.image.temp.stack;

public interface Stack<E> {

    public E push(E e);

    public E pop();

    public E peek();

    public boolean empty();
    public int size();
}
