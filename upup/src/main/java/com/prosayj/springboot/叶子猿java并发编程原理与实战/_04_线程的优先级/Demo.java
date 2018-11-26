package com.prosayj.springboot.叶子猿java并发编程原理与实战._04_线程的优先级;
/**
 * @description 线程的优先级
 * @author yangjian
 * @Date 17:50 2018/7/28
 * @since 1.0.0
 */

public class Demo {
	
	public static void main(String[] args) {
		
		
		Thread t1 =  new Thread(new Target());
		Thread t2 =  new Thread(new Target());
		
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		
	}

}
