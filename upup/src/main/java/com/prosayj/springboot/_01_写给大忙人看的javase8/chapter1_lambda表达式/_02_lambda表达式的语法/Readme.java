package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._02_lambda表达式的语法;

/**
 * @author yangjian
 * @description lambda的基本语法？
 * Java中的Lambda表达式基本语法
 * (argument) -> (body)
 * 比如说：
 * 1：(arg1, arg2...) -> { body }、
 * 2:(arg1, arg2...) -> { body }、
 * 3:(type1 arg1, type2 arg2...) -> { body }
 * <p>
 * lambda表达式的结构?
 * 1：⼀个 Lambda 表达式可以有零个或多个参数
 * 2：参数的类型既可以明确声明，也可以根据上下文来推断。例如： (int a)与(a)效果相同
 * 3：所有参数需包含在圆括号内，参数之间用逗号相隔。例如： (a, b) 或 (int a, int b) 或 (String a, int b, float c)
 * 4：空圆括号代表参数集为空。例如： () -> 42
 * 5：当只有⼀个参数，且其类型可推导时，圆括号（）可省略。例如： a -> return a*a
 * 6：Lambda 表达式的主体可包含零条或多条语句。
 * 7：如果 Lambda 表达式的主体只有⼀条语句，花括号{}可省略。匿名函数的返回类型与该主体表达式⼀致
 * 8：如果 Lambda 表达式的主体包含⼀条以上语句，则表达式必须包含在花括号{}中（形成代码块）。匿名函数的返回类型与代码块的返回类型⼀致，若没有返回则为空。
 * <p>
 * <p>
 * @Date 下午 11:06 2019/9/10
 * @since 1.0.0
 */
public class Readme {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        m1(a, b);
    }

    private static void m1(int a, int b) {
        Integer.compare(a, b);
    }

    class MyComparator implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
