package com.prosayj.springboot.spring源码深度剖析._02_容器的基本实现;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/9 上午 12:37
 * @since 1.0.0
 */
public class MyTestBean {
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}