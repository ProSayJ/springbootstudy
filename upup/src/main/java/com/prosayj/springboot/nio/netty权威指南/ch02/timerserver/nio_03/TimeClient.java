package com.prosayj.springboot.nio.netty权威指南.ch02.timerserver.nio_03;

/**
 * @description
 * @author yangjian
 * @Date 20:38 2018/9/8
 * @since 1.0.0
 */
public class TimeClient {

    /**
     * @param args
     */
    public static void main(String[] args) {

	int port = 8080;
	if (args != null && args.length > 0) {
	    try {
		port = Integer.valueOf(args[0]);
	    } catch (NumberFormatException e) {
		// 采用默认值
	    }
	}
	while (true){
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001")
                .start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
    }

}
