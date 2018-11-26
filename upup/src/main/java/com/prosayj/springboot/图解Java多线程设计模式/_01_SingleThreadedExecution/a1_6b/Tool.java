package com.prosayj.springboot.图解Java多线程设计模式._01_SingleThreadedExecution.a1_6b;

public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ " + name + " ]";
    }
}
