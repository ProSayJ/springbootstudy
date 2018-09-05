package com.prosayj.springboot.designmode.研磨设计模式._03_adapter.example4;


import java.util.List;

/**
 * @author yangjian
 * @description DB存储日志的实现，为了简单，这里就不去真的实现和数据库交互了，示意一下
 * @Date 18:00 2018/8/5
 * @since 1.0.0
 */

public class LogDbOperate implements LogDbOperateApi {

    @Override
    public void createLog(LogModel lm) {
        System.out.println("now in LogDbOperate createLog,lm=" + lm);
    }

    @Override
    public List<LogModel> getAllLog() {
        System.out.println("now in LogDbOperate getAllLog");
        return null;
    }

    @Override
    public void removeLog(LogModel lm) {
        System.out.println("now in LogDbOperate removeLog,lm=" + lm);
    }

    @Override
    public void updateLog(LogModel lm) {
        System.out.println("now in LogDbOperate updateLog,lm=" + lm);
    }

}
