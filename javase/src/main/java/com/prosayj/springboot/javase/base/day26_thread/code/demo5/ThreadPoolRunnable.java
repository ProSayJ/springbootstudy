package com.prosayj.springboot.javase.base.day26_thread.code.demo5;

public class ThreadPoolRunnable implements Runnable {
	public void run(){
		System.out.println(Thread.currentThread().getName()+" 线程提交任务");
	}
}
