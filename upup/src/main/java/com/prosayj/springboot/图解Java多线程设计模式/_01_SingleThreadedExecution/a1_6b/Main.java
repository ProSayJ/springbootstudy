package com.prosayj.springboot.图解Java多线程设计模式._01_SingleThreadedExecution.a1_6b;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        Pair pair = new Pair(spoon, fork);
        new EaterThread("Alice", pair).start();
        new EaterThread("Bobby", pair).start();
    }
}
