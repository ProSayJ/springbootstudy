package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._01_array_basics;

/**
 * @author yangjian
 * @description 数组的helloworld
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 14:13
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        System.out.println("========");

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);
        System.out.println("=============");

        for (int score : scores){
            System.out.println(score);
        }
        scores[0] = 96;
        System.out.println("=============");
        for (int i = 0; i < scores.length; i++){
            System.out.println(scores[i]);
        }
    }
}
