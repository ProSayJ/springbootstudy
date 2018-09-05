package com.prosayj.springboot.designmode.研磨设计模式._11_observer.example4;

import java.util.*;

public class NewsPaper extends Observable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setChanged();
        this.notifyObservers(this.content);
        //this.notifyObservers();
    }
}
