package com.prosayj.springboot.nio.netty权威指南.ch02.timerserver.nio_03;

import java.io.IOException;

/**
 * @author yangjian
 * @description
 * @Date 20:39 2018/9/8
 * @since 1.0.0
 */
public class TimeServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
