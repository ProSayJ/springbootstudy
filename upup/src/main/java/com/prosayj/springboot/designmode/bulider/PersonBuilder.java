package com.prosayj.springboot.designmode.bulider;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/2/6 14:15
 * @since 1.0.0
 */
public interface PersonBuilder {
    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();//组装
}
