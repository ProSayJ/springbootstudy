package com.prosayj.springboot.designmode.研磨设计模式._03_adapter.example1;

/**
 * @author yangjian
 * @description 定义客户端使用的接口，与特定领域相关
 * @Date 17:54 2018/8/5
 * @since 1.0.0
 */

public interface Target {
    /**
     * 示意方法，客户端请求处理的方法
     */
    public void request();
}
