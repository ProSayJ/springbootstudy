package com.prosayj.springboot.图解Java多线程设计模式._01_SingleThreadedExecution.a1_6b;

public class Pair {
    private final Tool lefthand;
    private final Tool righthand;
    public Pair(Tool lefthand, Tool righthand) {
        this.lefthand = lefthand;
        this.righthand = righthand;
    }
    @Override
    public String toString() {
        return "[ " + lefthand + " and " + righthand + " ]";
    }
}
