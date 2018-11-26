package com.prosayj.springboot.图解Java多线程设计模式._01_SingleThreadedExecution.a1_6b;

public class EaterThread extends Thread {
    private String name;
    private final Pair pair;
    public EaterThread(String name, Pair pair) {
        this.name = name;
        this.pair = pair;
    }
    @Override
    public void run() {
        while (true) {
            eat();
        }
    }
    public void eat() {
        synchronized (pair) {
            System.out.println(name + " takes up " + pair + ".");
            System.out.println(name + " is eating now, yum yum!");
            System.out.println(name + " puts down " + pair + ".");
        }
    }
}
