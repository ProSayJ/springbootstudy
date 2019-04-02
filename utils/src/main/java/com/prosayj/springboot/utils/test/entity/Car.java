package com.prosayj.springboot.utils.test.entity;


import java.io.Serializable;

/**
 * 描述：
 *
 **/
public class Car implements Serializable {

    private String name;

    private Float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
