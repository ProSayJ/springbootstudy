package com.prosayj.springboot.designmode.bulider.demo00;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/2/6 14:16
 * @since 1.0.0
 */
public class ManBuilder implements PersonBuilder {
    Person person;

    public ManBuilder() {
        //创建一个person实例，用于调用set方法
        person = new Person();
    }

    @Override
    public void buildBody() {
        person.setBody("建造身体部分");
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造四肢部分");
    }

    @Override
    public void buildHead() {
        person.setHead("建造头部部分");
    }

    @Override
    public Person buildPerson() {
        // 返回一个person实例
        return person;
    }
}
