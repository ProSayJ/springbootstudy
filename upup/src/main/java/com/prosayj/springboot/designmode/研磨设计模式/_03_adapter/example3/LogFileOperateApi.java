package com.prosayj.springboot.designmode.研磨设计模式._03_adapter.example3;

import java.util.List;

/**
 * @author yangjian
 * @description 日志文件操作接口
 * @Date 17:59 2018/8/5
 * @since 1.0.0
 */
public interface LogFileOperateApi {
    /**
     * 读取日志文件，从文件里面获取存储的日志列表对象
     *
     * @return 存储的日志列表对象
     */
    public List<LogModel> readLogFile();

    /**
     * 写日志文件，把日志列表写出到日志文件中去
     *
     * @param list 要写到日志文件的日志列表
     */
    public void writeLogFile(List<LogModel> list);
}
