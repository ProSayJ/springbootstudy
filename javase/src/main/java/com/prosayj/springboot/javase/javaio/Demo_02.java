package com.prosayj.springboot.javase.javaio;

import java.io.*;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 14:04
 * @since 1.0.0
 */
public class Demo_02 {
    public static void main(String[] args) throws IOException {
        String path = Demo_02.class.getResource("/").getPath();
        String pathname = path+ "application.properties";
        System.out.println(pathname);
        File file = new File(pathname);
        InputStream inputStream = new FileInputStream(file);
        int read = inputStream.read();
        System.out.println(read);
    }
}
