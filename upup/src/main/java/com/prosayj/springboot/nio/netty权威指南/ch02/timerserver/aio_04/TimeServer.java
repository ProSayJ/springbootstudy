package com.prosayj.springboot.nio.netty权威指南.ch02.timerserver.aio_04;

import java.io.IOException;

/**
 * @author yangjian
 * @description
 * @Date 22:31 2018/9/9
 * @since 1.0.0
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
