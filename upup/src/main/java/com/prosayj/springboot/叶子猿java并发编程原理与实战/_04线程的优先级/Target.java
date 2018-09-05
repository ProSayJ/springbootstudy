package com.prosayj.springboot.叶子猿java并发编程原理与实战._04线程的优先级;

public class Target implements Runnable {

	@Override
	public void run() {

		while(true) {
			System.out.println(Thread.currentThread().getName() + " ...");
//			Thread.sleep(1);
		}
		
	}

}
