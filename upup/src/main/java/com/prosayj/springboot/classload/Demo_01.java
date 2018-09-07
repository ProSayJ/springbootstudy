package com.prosayj.springboot.classload;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 13:28
 * @since 1.0.0
 */
public class Demo_01 {
    public static void main(String[] args) {
        InputStream in = System.in;
        PrintStream out = System.out;
        PrintStream err = System.err;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入一个数字：");
            String s = scanner.nextLine();
            if ("exit".equalsIgnoreCase(s)) {
                System.exit(0);
            }
            System.out.println("输入的数字是：" + s);
        }
    }
}
