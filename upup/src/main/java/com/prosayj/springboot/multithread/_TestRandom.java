package com.prosayj.springboot.multithread;

import java.util.Random;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/18 14:40
 * @since 1.0.0
 */
public class _TestRandom {
    public static void main(String[] args) {
        Random r = new Random();
        r.nextInt(10);
        while (true) {
            int x = r.nextInt(10);
            System.out.println(x);
            if (x == 0) {
                break;
            }
        }
/*
        while (true){
            int x = r.nextInt(10);
            System.out.println(x);
            if (x == 10) {
                break;
            }
        }
*/
    }
}
