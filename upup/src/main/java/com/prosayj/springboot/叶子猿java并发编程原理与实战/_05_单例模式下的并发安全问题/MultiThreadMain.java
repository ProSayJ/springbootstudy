package com.prosayj.springboot.叶子猿java并发编程原理与实战._05_单例模式下的并发安全问题;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {
	
	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(20);
		
		for(int i = 0;i<20;i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + ":" +Singleton3.getInstance().toString());
				}
			});
		}
		
		threadPool.shutdown();
		
		
	}

}
