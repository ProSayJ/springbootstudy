package com.prosayj.springboot.spring源码深度剖析.第5章_bean的加载;


import org.springframework.beans.factory.FactoryBean;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/12/1 下午 11:37
 * @since 1.0.0
 */
public class CarFactoryBean implements FactoryBean<Car> {
    //接收逗号分隔的属性设置信息
    private String carInfo;
    public String getCarInfo() {
        return carInfo;
    }
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }



}
