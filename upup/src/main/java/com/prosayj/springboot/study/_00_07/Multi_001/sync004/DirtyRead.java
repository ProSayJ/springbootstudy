package com.prosayj.springboot.study._00_07.Multi_001.sync004;

/**
 * @author yangjian
 * @description 业务整体需要使用完整的synchronized，保持业务的原子性。
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/1 0:45
 * @since 1.0.0
 */
public class DirtyRead {

    private String username = "z3";
    private String password = "333";
    private static final Long SLEEP_TIME_3000 = 3000L;
    private static final Long SLEEP_TIME_2000 = 2000L;
    private static final Long SLEEP_TIME_1000 = 1000L;

    private synchronized void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(SLEEP_TIME_2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.password = password;

        System.out.println("setValue最终结果：username = " + username + " , password = " + password);
    }

    public /*synchronized*/ void getValue() {
        System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
    }

    public static void main(String[] args) throws Exception {
        final DirtyRead dr = new DirtyRead();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dr.setValue("l4", "444");
            }
        });
        t1.start();
        Thread.sleep(SLEEP_TIME_2000);
        dr.getValue();
    }


}
