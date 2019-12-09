package com.prosayj.springboot.spring源码深度剖析.第5章_bean的加载;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/12/1 下午 11:36
 * @since 1.0.0
 */
public class Car {
    private int maxSpeed;
    private String brand;
    private double price;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
