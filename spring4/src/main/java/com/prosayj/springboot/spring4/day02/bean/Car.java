package com.prosayj.springboot.spring4.day02.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car1")//可以手动指定容器创建的bean的名称
//@Component//默认的bean的名称是类名称的小写
public class Car {
    @Value("玛莎拉蒂")
    private String name;
    @Value("呕吐绿")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", color=" + color + "]";
    }


}
