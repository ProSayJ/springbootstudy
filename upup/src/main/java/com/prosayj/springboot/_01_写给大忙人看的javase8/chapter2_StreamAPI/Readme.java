package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI;

import org.junit.Test;

import java.util.*;

/**
 * @author yangjian
 * @description lambda效率问题
 * m1()方法出现的问题：
 * 逻辑不清晰
 * 多个逻辑放在了⼀个方法中，不符合单⼀职责原则
 * 针对m1()方法于是分单一职责，可以使用方式2来完成需求
 * <p>
 * 方式2出现的问题：
 * 效率低下
 * <p>
 * 我们使用流来解决方式2的问题：
 * 流：
 * 1：Collection提供了新的stream()⽅法
 * 2：流不存储值，通过管道的⽅式获取值
 * 3：本质是函数式的，对流的操作会⽣成⼀个结果，不过并不会修改底层的数据源，集合可以作为流的底层数据源
 * 4：延迟查找，很多流操作（过滤、映射、排序等）都可以延迟实现。
 * <p>
 * Stream
 * 1：Java 8 中的 Stream 是对集合对象功能的增强，它专注于对集合对象进⾏各种⾮常便利、⾼效的聚合操作，或者⼤批量数据操作
 * 2：Stream API 借助于Lambda 表达式，极⼤地提⾼了编程效率和程序可读性
 * 3：提供串⾏和并⾏两种模式进⾏汇聚操作，并发模式能够充分利⽤多核处理器的优势，使⽤ fork/join 并⾏⽅式来拆分任务和加速处理过程
 * 4：Stream 不是集合元素，它不是数据结构，并不保存数据，它是有关算法和计算的
 * 5：Stream更像⼀个⾼级版本的 Iterator。
 * 6：原始版本的 Iterator，⽤户只能显式地⼀个⼀个遍历元素并对其执⾏某些操作；⾼级版本的 Stream，⽤户只要给出需要对其包含的元素执⾏什么操作，
 * ⽐如 “过滤掉⻓度⼤于10 的字符串”、 “获取每个字符串的⾸字⺟”等， Stream 会隐式地在内部进⾏遍历，并做出相应的数据转换
 * 7：Stream 就如同⼀个迭代器（Iterator），单向，不可往复，数据只能遍历⼀次
 * 8：和迭代器⼜不同的是， Stream 可以并⾏化操作，迭代器只能命令式地、串⾏化操作
 * 9：当使⽤串⾏⽅式去遍历时，每个 item 读完后再读下⼀个item
 * 10：使⽤并⾏去遍历时，数据会被分成多个段，其中每⼀个都在不同的线程中处理，然后将结果⼀起输出
 * 11：Stream 的并⾏操作依赖于 Java7 中引⼊的 Fork/Join 框架
 *
 * Stream构成
 * 1：获取⼀个数据源（source）→ 数据转换→执⾏操作获取想要的结果
 * 2：每次转换原有 Stream 对象不改变，返回⼀个新的Stream 对象（可以有多次转换），这就允许对其操作可以像链条⼀样排列，变成⼀个管道（Pipeline）
 *
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/10 下午 11:09
 * @since 1.0.0
 */
public class Readme {
    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(9, 1, 2, 5, 3, 7, 4, 0);
        //问题：对于上述集合中的每⼀个元素，找出偶数、将其乘以2，然后打印出第⼀个大于5的元素值。

        //方式1：
        m1(numbers);
        System.out.println("====================");

        //方式2：
        //1：获取所有的偶数
        List<Integer> l1 = new ArrayList<>();
        for (int n : numbers) {
            if (isEven(n)) l1.add(n);
        }
        //2：所有偶数乘以2
        List<Integer> l2 = new ArrayList<>();
        for (int n : l1) {
            l2.add(doubleIt(n));
        }
        //3：判断所有偶数的两倍的结果是否是大于5，大于五则收集起来
        List<Integer> l3 = new ArrayList<>();
        for (int n : l2) {
            if (isGreaterThan5(n)) {
                l3.add(n);
            }
        }
        //4：获取收集的第一个元素
        System.out.println(l3.get(0));
        System.out.println("====================");
    }

    /**
     * 找出偶数、将其乘以2，然后打印出第⼀个大于5的元素值。
     *
     * @param list
     */
    private void m1(List<Integer> list) {
        list.forEach(data -> {
            int mul = 2;
            if (data % mul == 0) {
                if (data * mul > 5) {
                    System.out.println(data);
                    return;
                }
            }
        });
    }


    /**
     * 获取偶数
     *
     * @param number
     * @return
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    //乘以2
    public int doubleIt(int number) {
        return number * 2;
    }

    //判断是否大于5
    public boolean isGreaterThan5(int number) {
        return number > 5;
    }
}
