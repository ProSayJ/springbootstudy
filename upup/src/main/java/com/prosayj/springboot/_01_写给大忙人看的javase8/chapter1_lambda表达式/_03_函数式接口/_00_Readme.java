package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._03_函数式接口;

/**
 * @author yangjian
 * @description 函数式接口
 * 1：函数式接⼝是只包含⼀个抽象方法声明的接口
 * 2：java.lang.Runnable 就是⼀种函数式接口，在Runnable 接口中只声明了⼀个⽅法 void run()
 * 3：每个Lambda 表达式都能隐式地赋值给函数式接口
 * <p>
 * java.lang.FunctionalInterface：
 * 1：标识所声明的接口为函数式接口(javadoc页面也会包含一条声明，说明该接口是函数式接口)
 * 2：如果不满足函数式接口的要求（编译器会检查是否只有一个实现），则编译器报错
 * 3：并非必须，但凡满足函数式接口条件的接口，编译器均将其看作是函数式接口，即便没有添加FunctionalInterface注解亦如此。
 * (从概念上讲：所有只含有一个方法的接口都是函数式接口，但是使用注解会使你的代码看上去更清楚。)
 * <p>
 * 关于函数式接口：
 * 1.如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口，
 * 2·如我们在某个接口上，声明了FunctionalInterface注解，那么译器会按照函数式接口的定义来要求该接口·
 * 3.如果某个接口只有一个抽象方法，但我们并没有绐接口声明FunctionalInterface注解，那么编译器依旧会将该接口看作是函式接口。
 * 4.函数式接口中如果复写了objetc类中的public的方法，则@FunctionalInterface依然认为该接口是函数式接口
 * <p>
 * 何为传递行为?例：
 * List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
 * 打印所有元素？
 * 不打印任何⼀个元素？
 * 打印所有偶数?
 * 打印⼤于4的所有数字?
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/10 下午 11:32
 * @since 1.0.0
 */
@FunctionalInterface
public interface _00_Readme {

    void m1();

    //void m2();
    default void m3() {
    }

    String toString();
}


class _02_Test {

    public void myTest(_00_Readme myFunctionalInterface) {
        System.out.println(1);
        myFunctionalInterface.m1();
        System.out.println(2);
    }


    public static void main(String[] args) {

        new _02_Test().myTest(new _00_Readme() {
            @Override
            public void m1() {
                System.out.println("hahha");
            }
        });
        System.out.println("---------------------");


        new _02_Test().myTest(() -> {
            System.out.println("hahha");
        });
        System.out.println("---------------------");


        _00_Readme myFunctionalInterface = () -> {
            System.out.println("hahha");
        };
        System.out.println("---------------------");

        System.out.println(myFunctionalInterface.getClass());
        System.out.println(myFunctionalInterface.getClass().getSuperclass());
        System.out.println(myFunctionalInterface.getClass().getInterfaces().length);
        System.out.println(myFunctionalInterface.getClass().getInterfaces()[0]);

    }

}
