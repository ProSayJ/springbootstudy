package com.prosayj.springboot.javase.homework.day01;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/14 22:20
 * @since 1.0.0
 */
public class _Test01 {
    public static  void main(String[] args){
   /*     for(int i = 0 ;i <=10 ;i++){
            ThreadNewDemo th = new ThreadNewDemo();
            th.start();
        }*/

        for(int i=0;i<10;i++){
            ThreadNewDemo1 th = new ThreadNewDemo1();
            Thread t1 = new Thread(th);
            t1.start();
        }
    }
}
/*
class ThreadNewDemo extends Thread{
    public void run(){
        System.out.println(getName());

    }
}
*/

class ThreadNewDemo1 implements Runnable{
    @Override
    public void run() {
      //  for(int i = 0 ;i <= 10 ;i++){
            System.out.println(Thread.currentThread().getName());
       // }

    }
}