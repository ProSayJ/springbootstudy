package com.prosayj.springboot.blog.core.common.enums;

import lombok.Getter;

/**
 * @author yangjian
 * @description 分类级别枚举
 * @Date 16:54 2019/5/10
 * @since 1.0.0
 */
@Getter
public enum CategoryRankEnum {

    /**
     * 一级
     */
    ROOT(-1),
    /**
     * 一级
     */
    FIRST(0),
    /**
     * 二级
     */
    SECOND(1),
    /**
     * 三级
     */
    THIRD(2);

    private int value;

    CategoryRankEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
