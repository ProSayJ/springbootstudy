package com.prosayj.springboot.designmode.研磨设计模式._11_observer._00;

/**
 * @author yangjian
 * @description 观察者
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/24 9:36
 * @since 1.0.0
 */
public interface Observer {
    /**
     * @description 当主题状态改变时, 会将一个String类型字符传入该方法的参数, 每个观察者都需要实现该方法
     * @param info
     * @author yangjian
     * @Date 9:39 2018/1/24
     * @since 1.0.0
     */
    public void update(String info);
}
