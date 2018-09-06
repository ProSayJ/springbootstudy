package com.prosayj.springboot.javase.base.helloworld_00;

/**
 * * @description 标识符
 * Java中，自己定义的内容
 * 自定义类的名字，上一个案例 HelloWorld
 * 标识符的规则：
 * 组成： 字母52个A-Z a-z 数字0-9 _ 下划线 $ 美元符
 * 注意： 不能数字开头，不能是关键字
 * 定义名字：
 * _abc  0a  a0  a#a  a$a   void
 * YES  NO  YES NO   YES   NO
 * 类的名字： 首字母大写，第二个单词首字母大写
 * BeiJingShiHaiDianQuYiYuan
 * MeiGuoJiaLiFuNiYa
 * 方法的名字：首字母小写，每个单词首字母大写
 * 程序当中输出：
 * 输出整数常量
 * 小数常量
 * 布尔常量
 * 字符常量
 * 字符串常量
 */
public class HelloWorld {
    //main主方法，固定格式，程序的入口点
    public static void main(String[] args) {

        //输出字符串常量，双引号包裹，可以写0-n个字符
        System.out.println("HelloWorld");
        //输出整数 十进制
        System.out.println(50);

        //输出整数，二进制, 数字开头0B
        System.out.println(0B11);

        //输出整数，八进制，数字开头0
        System.out.println(051);

        //输出整数，十六进制，数组开头0X  0-9 A-F
        System.out.println("十六进制" + 0XE);

        //输出浮点数据
        System.out.println(5.0);

        //输出布尔数据，只有2个值，true，false 关键字
        System.out.println(true);
        System.out.println(false);

        //输出字符常量，单引号包裹，只能写1个字符
        System.out.println('a');
    }
}