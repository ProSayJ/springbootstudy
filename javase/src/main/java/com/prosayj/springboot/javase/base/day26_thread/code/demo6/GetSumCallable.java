package com.prosayj.springboot.javase.base.day26_thread.code.demo6;

import java.util.concurrent.Callable;

public class GetSumCallable implements Callable<Integer> {
    private int a;

    public GetSumCallable(int a) {
        this.a = a;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
