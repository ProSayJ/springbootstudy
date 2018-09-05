package com.prosayj.springboot.designmode.observer._01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description 订阅者 被别人订阅的人，因为她送牛奶，需要被别人观察
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/29 23:41
 * @since 1.0.0
 */
public class SendMilk {
    //小本子
    private List<Person> peoples = new ArrayList<Person>();

    //送牛奶的行为
    public void sendMike() {
        //遍历每小本子的人，通知他们牛奶到了
        for (Person person : peoples) {
            person.phone("你好你好，您的牛奶送到了哦！！");
        }
    }

    public void addPeople(Person p) {
        peoples.add(p);

    }
}
