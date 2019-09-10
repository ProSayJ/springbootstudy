package com.prosayj.springboot.mybatis3.execise.constant;

/**
 * @author yangjian
 * @description
 * @Date 下午 10:28 2019/9/3
 * @since 1.0.0
 */
public enum ArticleTypeEnum {

    JAVA(1),
    DUBBO(2),
    SPRING(4),
    MYBATIS(8);

    private int code;

    ArticleTypeEnum(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public static ArticleTypeEnum find(int code) {
        for (ArticleTypeEnum at : ArticleTypeEnum.values()) {
            if (at.code == code) {
                return at;
            }
        }

        return null;
    }
}
