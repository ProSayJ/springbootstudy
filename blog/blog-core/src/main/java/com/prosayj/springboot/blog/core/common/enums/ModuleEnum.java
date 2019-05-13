package com.prosayj.springboot.blog.core.common.enums;

import lombok.Getter;


/**
 * @author yangjian
 * @description 模块枚举
 * @Date 16:57 2019/5/10
 * @since 1.0.0
 */
@Getter
public enum ModuleEnum {
    /**
     * 文章模块
     */
    ARTICLE(0),
    /**
     * 图书模块
     */
    BOOK(1),
    /**
     * 图书笔记模块
     */
    BOOK_NOTE(2);

    private int value;

    ModuleEnum(int value) {
        this.value = value;
    }
}
