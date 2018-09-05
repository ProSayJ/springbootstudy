package com.prosayj.springboot.javase.javaio;

import java.net.URL;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 14:22
 * @since 1.0.0
 */
public class Demo_00 {
    public static void main(String[] args) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("");
        URL resource1 = Demo_00.class.getResource("/");
        URL resource2 = Demo_00.class.getResource("");
        URL resource3 = Demo_00.class.getClassLoader().getResource("");
        URL resource4 = Demo_00.class.getClassLoader().getResource("/");
        URL systemResource = ClassLoader.getSystemResource("");
        URL systemResource1 = ClassLoader.getSystemResource("/");
        System.out.println("resource=" + resource);
        System.out.println("resource1=" + resource1);
        System.out.println("resource2=" + resource2);
        System.out.println("resource3=" + resource3);
        System.out.println("resource4=" + resource4);
        System.out.println("systemResource=" + systemResource);
        System.out.println("systemResource1=" + systemResource1);
    }
}
