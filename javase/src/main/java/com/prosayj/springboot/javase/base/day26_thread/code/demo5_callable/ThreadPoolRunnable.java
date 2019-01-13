package com.prosayj.springboot.javase.base.day26_thread.code.demo5_callable;

public class ThreadPoolRunnable implements Runnable {
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+" 线程提交任务");
	}
}
