package com.prosayj.springboot.javase.base.day15_string.code;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/12 下午 03:43
 * @since 1.0.0
 */
public class Interview_String {
    public static void main(String[] args) {
        String s1 = "abc1";
        String s2 = "abc1";
        System.out.println("s1 == s2--->" + (s1 == s2));

        String s3 = new String("abc3");
        String s4 = new String("abc3");
        System.out.println("s3 == s4--->" + (s3 == s4));
        System.out.println("s3.intern() == s4.intern()--->" + (s3.intern() == s4.intern()));


        String s5 = new String("hello5") + new String("world5");
        String s6 = "hello5world5";
        System.out.println("s5 == s6--->" + (s5 == s6));


        String s7 = new String("hello7") + new String("world7");
        System.out.println("s7.intern() == s7--->" + (s7.intern() == s7));


        String s8 = new String("hello8") + new String("world8");
        System.out.println("s8.intern() == s8--->" + (s8.intern() == s8));
        String s9 = new String("hello8") + new String("world8");
        System.out.println("s9.intern() == s9--->" + (s9.intern() == s9));
        System.out.println("s9.intern() == s9--->" + (s8.intern() == s9));
        System.out.println("s9.intern() == s9--->" + (s9.intern() == s8));

    }
}
