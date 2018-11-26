package com.prosayj.springboot.java数据结构.玩转数据结构._02_Queues;

public class _Test {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
