package com.prosayj.springboot.图解Java多线程设计模式._01_SingleThreadedExecution.a1_5;

public class SecurityGate {
    private int counter = 0;
    public void enter() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter + 1;
    }
    public void exit() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter - 1;
    }
    public int getCounter() {
        return counter;
    }
}
