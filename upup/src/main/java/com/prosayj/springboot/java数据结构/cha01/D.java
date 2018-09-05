package com.prosayj.springboot.java数据结构.cha01;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/19 11:07
 * @since 1.0.0
 */
public class D extends A {
    public void meth() {
        D d = new D();
        d.t = 1;
        t = 2;
        A a = new A();
        a.t = 9;
        C c = new C();
        c.t = 5;
        System.out.println(t);

    }

    public static void main(String[] args) {
        new D().meth();
    }
}
