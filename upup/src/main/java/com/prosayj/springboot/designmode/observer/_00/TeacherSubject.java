package com.prosayj.springboot.designmode.observer._00;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description 被观察者
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/24 9:37
 * @since 1.0.0
 */
public class TeacherSubject implements Subject {
    /**
     * @description 用来存放和记录观察者
     * @author yangjian
     * @Date 9:43 2018/1/24
     * @param null
     * @throws TODO
     * @since 1.0.0
     */
    private List<Observer> observers = new ArrayList<Observer>();
    //记录状态的字符串
    private String info;

    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if (i >= 0) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer o = (Observer) observers.get(i);
                o.update(info);
        }
    }

    //布置作业的方法,在方法最后,需要调用notifyObserver()方法,通知所有观察者更新状态
    public void setHomework(String info) {
        this.info = info;
        System.out.println("今天的作业是" + info);
        this.notifyObserver();
    }

}
