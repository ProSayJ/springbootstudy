package com.prosayj.springboot.javase.homework.day02;

import java.util.Scanner;

public class Demo001 {
    static void Add(int n){
        int s=1;
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                s=i*j;
                if(s<10){                                  //用于乘法表的对齐
                    System.out.print(j+"*"+i+"="+s+"  ");
                }
                else System.out.print(j+"*"+i+"="+s+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入数字：");
        int i;
        Scanner reader=new Scanner(System.in);
        i=reader.nextInt();
        Demo001.Add(i);
    }
}
