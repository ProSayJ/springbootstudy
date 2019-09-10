package com.prosayj.springboot.mybatis3.execise.constant;

/**
 * @description
 * @author yangjian
 * @Date 下午 10:29 2019/9/3
 * @since 1.0.0
 */
public enum ArticleCategoryEnum {

    JAVA(1),
    DUBBO(2),
    SPRING(3),
    MYBATIS(4);

    private int code;

    ArticleCategoryEnum(int code) {
        this.code = code;
    }
}
