package com.prosayj.springboot.叶子猿java并发编程原理与实战._05_单例模式下的并发安全问题;

/**
 * @description 饿汉式单例模式
 * @author yangjian
 * @Date 17:57 2018/7/28
 * @since 1.0.0
 */

public class Singleton3 {

	private Singleton3() {}
	
	private static volatile Singleton3 instance;

    /**
     * 双重检查加锁
     *
     * @return
     */
	public static Singleton3 getInstance () {
		// 自旋   while(true)
		if(instance == null) {
			synchronized (Singleton3.class) {
				if(instance == null) {

					try {
						Thread.sleep(50L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					instance = new Singleton3();  // 指令重排序

                    // 申请一块内存空间   // 1
                    // 在这块空间里实例化对象  // 2
                    // instance的引用指向这块空间地址   // 3
				}
			}
		}
		return instance;
	}

    // 多线程的环境下
    // 必须有共享资源
    // 对资源进行非原子性操作

}
