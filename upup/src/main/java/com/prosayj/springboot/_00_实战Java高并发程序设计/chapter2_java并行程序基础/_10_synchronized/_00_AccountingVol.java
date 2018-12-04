package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._10_synchronized;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:51
 * @since 1.0.0
 */
public class _00_AccountingVol {
    private static volatile int i = 0;
    /**
     * 主函数是通过两个线程对i进行累加操作,最终的正确结果应为20000000,但是实际运行却远远小于正确数值,因为多个线程同事对i进行写入操作时,
     * 其中一个线程的结果会覆盖另外一个线程的操作,线程不安全导致了这种冲突.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 10000000; j++) {
                i++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 10000000; j++) {
                i++;
            }
        });
        thread1.start();
        thread2.start();

        //两个join阻塞了主线程，保证了thread1和thread1执行完成之后主线程才打印出i的值。
        thread1.join();
        thread2.join();

        System.out.println(i);
    }

}
