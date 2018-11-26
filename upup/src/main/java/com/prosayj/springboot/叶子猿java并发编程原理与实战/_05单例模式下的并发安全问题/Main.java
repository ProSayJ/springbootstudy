package com.prosayj.springboot.叶子猿java并发编程原理与实战._05单例模式下的并发安全问题;
/**
 * @description 单线程下单例线程的安全
 * @author yangjian
 * @Date 18:_01_SingleThreadedExecution 2018/7/28
 * @since 1.0.0
 */

public class Main {
	
	public static void main(String[] args) {
		
		Singleton2 s1 = Singleton2.getInstance();
		Singleton2 s2 = Singleton2.getInstance();
		Singleton2 s3 = Singleton2.getInstance();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

        Singleton s4 = Singleton.getInstance();
        Singleton s5 = Singleton.getInstance();
        Singleton s6 = Singleton.getInstance();
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
    }

}
