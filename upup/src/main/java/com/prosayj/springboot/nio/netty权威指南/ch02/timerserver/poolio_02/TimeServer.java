package com.prosayj.springboot.nio.netty权威指南.ch02.timerserver.poolio_02;

import com.prosayj.springboot.nio.netty权威指南.ch02.timerserver.blockio_01.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2018/9/6 0:24
 * @since 1.0.0
 */
public class TimeServer {

    /**
     * @param args
     * @throws IOException
     * hello
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
//                 采用默认值
            }

        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
//            创建IO任务线程池
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(
                    50, 10000);
            while (true) {
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
