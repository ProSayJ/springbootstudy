package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._00_函数式编程基础;

import java.util.function.Supplier;

public class _01_Supplier {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 2, 1, 10};
        getMax(() -> {
            int temp = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > temp) {
                    temp = arr[i];
                }

            }
            return temp;
        });
    }

    public static void getMax(Supplier<Integer> supplier) {
        Integer result = supplier.get();//无参数有返回值
        System.out.println(result);
    }
}

