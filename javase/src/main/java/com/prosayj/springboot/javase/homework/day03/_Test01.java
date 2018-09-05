package com.prosayj.springboot.javase.homework.day03;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 0:59
 * @since 1.0.0
 */
//请说说你了解的一些设计模式，并用代码来演示表示
public class _Test01 {

}

//懒汉式单例类.在第一次调用的时候实例化自己
 class Singleton {
    private Singleton() {}
    private static Singleton single=null;
    //静态工厂方法
    public static synchronized  Singleton getInstance() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }
}
//懒汉模式线程不安全，使用静态内部类进行优化，既实现了线程安全，又避免了同步带来的性能影响。
class Singleton2{
    private static class LazyHolder{
        private static final Singleton2 Instance = new Singleton2();
    }
    private Singleton2(){}
    public static final Singleton2 getInstance(){
        return LazyHolder.Instance;

    }
}

//饿汉式单例类.在类初始化时，已经自行实例化
//饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的
 class Singleton1 {
    private Singleton1() {}
    private static final Singleton1 single = new Singleton1();
    //静态工厂方法
    public static Singleton1 getInstance() {
        return single;
    }
}