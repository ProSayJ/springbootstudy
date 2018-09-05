package com.prosayj.springboot.javase.homework.day01;

import java.util.Random;
import java.util.Scanner;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/14 22:48
 * @since 1.0.0
 */
/*04：请在_Test03中编写一个猜数字的小程序，系统随机产生0-100的随机数，用户键盘输入一个数字，程序判断用户输入的数子的大小，
        并给出提示："大了"或者"小了",如果用户输入错误，需要循环继续输入，直到用户输入的数字是正确的，程先退出，结束循环。
        参考_Test03，等自己写代码的时候把参考的代码注释掉，随机数不清楚可以参考javese的api*/
public class _Test03 {
    public static void main(String[] args) {
         /*       Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println("请输入数字=====");
            int num = scanner.nextInt();
            System.out.println(num);
            System.out.println("还可以循环输入：" + (10 - i) + "次");
        }
        */
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        //1.系统产生0-100随机数
        int i = r.nextInt(100);
        System.out.println("请输入你要猜的数字：");
        while (true){
            //2.获取用户输入数字
            int a = s.nextInt();
            //3.判断用户输入的数字和随机数比大小
            if(a>i){
                System.out.println("您猜的数字大了");
                continue;
            }else if(a<i){
                System.out.println("您猜的数字小了");
                continue;
            }else {
                System.out.println("猜对了");
                return;
            }
        }




    }
}
