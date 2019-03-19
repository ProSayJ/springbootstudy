package com.prosayj.springboot.blog.models.image.temp.stack;


public class LinkedStack<E> implements Stack<E> {
    private Node first;
    private Node last;
    private int size;

    private final class Node<E> {
        Node pre;
        Node next;
        E data;

        public Node(Node pre, Node next, E e) {
            this.pre = pre;
            this.next = next;
            this.data = e;
        }

    }

    public E push(E e) {
        addFirst(e);
        return e;
    }


    public E pop() {
        E e = removeFirst();
        return null;
    }

    public E peek() {
        return (E) first.data;
    }

    public boolean empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void addFirst(E e) {
        Node oldFirst = first;
        Node newFirst = new Node(null, oldFirst, e);
        first = newFirst;
        if (oldFirst == null) {
            last = newFirst;
        } else {
            oldFirst.pre = newFirst;
            last = oldFirst;
        }
        size++;
    }

    private E removeFirst() {
        Node oldFirst = first;
        first = oldFirst.next;
        oldFirst.next = null;
        first.pre = null;
        E e = (E) oldFirst.data;
        oldFirst.data = null;
        size--;
        return e;
    }
}
