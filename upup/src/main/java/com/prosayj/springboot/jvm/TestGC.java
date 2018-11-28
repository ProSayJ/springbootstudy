package com.prosayj.springboot.jvm;

/**
 -server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:+PrintGC:堆上分配

 -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC

 */
public class TestGC {
    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }

    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

}
