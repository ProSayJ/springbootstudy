package com.prosayj.springboot.designmode.研磨设计模式._06_Bulider.demo00;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/2/6 14:18
 * @since 1.0.0
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder pb) {
        //按照 身体--->头部--->四肢 的顺序创建人物
        pb.buildHead();
        pb.buildBody();
        pb.buildFoot();
        return pb.buildPerson();
    }
}
