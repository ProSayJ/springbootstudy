package com.prosayj.springboot.utils;

import com.prosayj.springboot.constants.LoggerModelEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/24 15:39
 * @since 1.0.0
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketUtils {
    public static final Logger log = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_UTILS.getModuleNickName());
    /**
     * 记录当前在线连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger();
    /**
     * 存放每个客户端对应的MyWebSocket对象
     */
    private static CopyOnWriteArraySet<WebSocketUtils> webSocketSet = new CopyOnWriteArraySet<WebSocketUtils>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //加入set中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
        log.info("有新连接加入！当前在线人数为{}" + getOnlineCount());
        try {
            this.sendMessage("websocket发送信息-test！！！！", session);
        } catch (IOException e) {
            log.error("IO异常:{}", e);
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为{}", getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public static void onMessage(String message, Session session) {
        log.info("来自客户端的消息:{}", message);
        //群发消息
        for (WebSocketUtils item : webSocketSet) {
            try {
                item.sendMessage(message, session);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public static void onError(Session session, Throwable error) {
        log.error("发生错误:{},{}", error, session);
        error.printStackTrace();
    }

    /**
     * 定时向前台web页面推送消息，便用websocket来做消息推送:
     * websocket  session发送文本消息有两个方法：getAsyncRemote()和getBasicRemote()
     * getAsyncRemote():异步非阻塞
     * getBasicRemote():同步是阻塞，由于getBasicRemote()的同步特性，并且它支持部分消息的发送即sendText(xxx,boolean isLast).
     * isLast的值表示是否一次发送消息中的部分消息，对于如下情况:
     * session.getBasicRemote().sendText(message, false);
     * session.getBasicRemote().sendBinary(data);
     * session.getBasicRemote().sendText(message, true);
     * 由于同步特性，第二行的消息必须等待第一行的发送完成才能进行，而第一行的剩余部分消息要等第二行发送完才能继续发送，所以在第二行会抛出IllegalStateException异常。
     * 如果要使用getBasicRemote()同步发送消息，则避免尽量一次发送全部消息，使用部分消息来发送。
     */
    public void sendMessage(String message, Session session) throws IOException {
//        this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
    }


    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, Session session) throws IOException {
        for (WebSocketUtils item : webSocketSet) {
            try {
                item.sendMessage(message, session);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized AtomicInteger getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount.getAndIncrement();
    }

    public static synchronized void subOnlineCount() {
        onlineCount.getAndDecrement();
    }
}
