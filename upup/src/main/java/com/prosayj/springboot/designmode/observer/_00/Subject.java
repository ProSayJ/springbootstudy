package com.prosayj.springboot.designmode.observer._00;

/**
 * @author yangjian
 * @description 订阅者
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/24 9:34
 * @since 1.0.0
 */
public interface Subject {
    /**
     * @param obj
     * @throws TODO
     * @description 添加观察者
     * @author yangjian
     * @Date 9:37 2018/1/24
     * @since 1.0.0
     */
    void addObserver(Observer obj);

    /**
     * @param obj
     * @throws TODO
     * @description 移除观察者
     * @author yangjian
     * @Date 9:38 2018/1/24
     * @since 1.0.0
     */
    void deleteObserver(Observer obj);

    /**
     * @throws TODO
     * @description 当主题方法改变时, 这个方法被调用, 通知所有的观察者
     * @author yangjian
     * @Date 9:38 2018/1/24
     * @since 1.0.0
     */
    void notifyObserver();
}
