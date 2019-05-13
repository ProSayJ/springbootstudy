package com.prosayj.springboot.blog.core.common.enums;

import lombok.Getter;


/**
 * @author yangjian
 * @description 菜单类型
 * @Date 16:54 2019/5/10
 * @since 1.0.0
 */
@Getter
public enum MenuTypeEnum {
    /**
     * 目录
     */
    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);

    private int value;

    MenuTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
