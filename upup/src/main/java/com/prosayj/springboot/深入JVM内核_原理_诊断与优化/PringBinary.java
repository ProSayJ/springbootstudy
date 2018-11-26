package com.prosayj.springboot.深入JVM内核_原理_诊断与优化;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/23 21:34
 * @since 1.0.0
 */
public class PringBinary {
    public static void main(String[] args) {
        printBinary(-6);
    }

    private static void printBinary(int num) {
        for (int i = 0; i < 32; i++) {
            int t = (num & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t);
        }

    }
}
