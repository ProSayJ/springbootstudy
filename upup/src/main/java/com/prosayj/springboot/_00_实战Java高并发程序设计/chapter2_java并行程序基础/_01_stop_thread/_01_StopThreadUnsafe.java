package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._01_stop_thread;


/**
 * @author yangjian
 * @description 不安全的停止线程的方法——stop
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/24 15:24
 * @since 1.0.0
 */
public class _01_StopThreadUnsafe {
    public static User user = new User();


    public static void main(String args[]) throws InterruptedException {
        new ReadObjectThread().start();

        while (true) {
            Thread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
            thread.stop();
        }
    }

    /**
     * 启动一个读线程：当用户名称和id不一样的时候，打印出来不一样的值
     */
    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    /**
     * 修改对象的值：用户名和id都是现在的值：
     */
    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ChangeObjectThread2 extends Thread {
        volatile boolean stopMe = false;

        public void setStopMe() {
            stopMe = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopMe) {
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(v + "");
                }
                Thread.yield();
            }
        }
    }

    static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User() {
            this.id = 0;
            this.name = "0";
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

}
