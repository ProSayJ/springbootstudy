package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yangjian
 * @description 允许多个线程同时访问：信号量(Semaphore)
 * <p>
 * 基础api：
 * semp.acquire();//尝试获取一个准入许可，无法获取则线程会等待，值到有现车释放一个许可或者当前线程被中断。
 * semp.availablePermits();//和acquire相似，但是不响应中断。
 * semp.tryAcquire();//尝试获取一个许可，成功返回true，失败返回false。不会进行等待，立即返回
 * semp.release();//获取许可以后，释放许可
 * <p>
 * @email yangjian@bubi.cn
 * @creatTime 2018/12/5 18:01
 * @since 1.0.0
 */
public class _06_SemapDemo implements Runnable {
    //指定信号量的准入数，即：同时能申请多少个许可
    final Semaphore semp = new Semaphore(5);
    //第二个参数可以指定是否公平
    final Semaphore semp2 = new Semaphore(5, true);

    @Override
    public void run() {
        try {
            //尝试获取一个准入许可
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + "<===>" + Thread.currentThread().getName() + ":done!!!!");
            //释放许可
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 总共20个线程,系统会以5个线程一组为单位,依次执行并输出
     *
     * @param args
     */
    public static void main(String args[]) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final _06_SemapDemo demo = new _06_SemapDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(demo);
        }
        executorService.shutdown();
    }
}

