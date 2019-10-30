package com.prosayj.springboot._00_实战Java高并发程序设计.chapter1_走入并行世界._1_3_4_无锁_LockFree;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFree {
    public static void main(String[] args) {
        AtomicInteger atomicVar = new AtomicInteger(0);
        int localVar = 2;
        while (!atomicVar.compareAndSet(localVar, localVar + 1)) {
            localVar = atomicVar.get();
        }
    }
}
