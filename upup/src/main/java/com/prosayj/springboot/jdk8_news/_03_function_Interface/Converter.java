package com.prosayj.springboot.jdk8_news._03_function_Interface;

/**
 * @author yangjian
 * @description
 * Lambda表达式如何匹配Java的类型系统？
 * 每一个lambda都能够通过一个特定的接口，与一个给定的类型进行匹配。一个所谓的函数式接口必须要有且仅有一个抽象方法声明。
 * 每个与之对应的lambda表达式必须要与抽象方法的声明相匹配。由于默认方法不是抽象的，因此你可以在你的函数式接口里任意添加默认方法。
 * *************************************************************
 * 任意只包含一个抽象方法的接口，我们都可以用来做成lambda表达式。
 * *************************************************************
 * 为了让你定义的接口满足要求，你应当在接口前加上@FunctionalInterface 标注。
 * 编译器会注意到这个标注，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常。
 * 在只有一个抽象方法的情况下注解是可以不写的，写是为了
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 15:50
 * @since 1.0.0
 */
@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}
