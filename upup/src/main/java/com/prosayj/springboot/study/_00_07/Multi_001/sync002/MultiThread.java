package com.prosayj.springboot.study._00_07.Multi_001.sync002;

/**
 * @author yangjian
 * @description 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
 * <p>
 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
 * @email ProSayj@gmail.com
 * @creatTime 2018/4/30 3:_01_SingleThreadedExecution
 * @since 1.0.0
 */
public class MultiThread {
    //常量
    private static int num = 0;
    public static final String A = "a";
    public static final String B = "b";

    /**
     * @param tag
     * @descriptionb
     * @author yangjian
     * @Date 0:27 2018/5/1
     * @since 1.0.0
     */
    public /*static*/ synchronized void printNum(String tag) {
        try {
            if (tag.equals(A)) {
                num = 100;
                System.out.println(Thread.currentThread().getName() + "==>tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println(Thread.currentThread().getName() + "==>tag b, set num over!");
            }
            System.out.println(Thread.currentThread().getName() + "==>tag " + tag + ", num = " + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //注意观察run方法输出顺序
    public static void main(String[] args) {
        //俩个不同的对象
        final MultiThread m1 = new MultiThread();
        final MultiThread m2 = new MultiThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum(A);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum(B);
            }
        });

        t1.start();
        t2.start();

    }


}
