package com.prosayj.springboot.javase.homework.day01_a;

import java.util.Random;
import java.util.Scanner;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/14 22:48
 * @since 1.0.0
 */
public class _Test03 {
    public static void main(String[] args) {
        guessNum(100);
    }

    public static void guessNum(int maxNum) {
        Scanner scanner = new Scanner(System.in);
        int result = new Random().nextInt(maxNum);
        int times = 0;
        while (true) {
            times++;
            System.out.println("=======请输入0-100之间的整数==========");
            int i = scanner.nextInt();
            if (result > i) {
                System.err.println("=======小了==========");
            } else if (result < i) {
                System.err.println("=======大了==========");
            } else {
                System.err.println("=======正确,您共猜了" + times + "次，程序结束==========");
                break;
            }
        }
    }
}
