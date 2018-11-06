/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.designmode.bulider.demo01;

/**
 * @author yangjian
 * @description 错误码常量
 * @email yangjian@bubi.cn
 * @creatTime 2017/11/30 10:04
 * @since 1.0.0
 */
public class ErrorCodeConstants {
    private ErrorCodeConstants() {
        throw new IllegalStateException("constant class");
    }

    /**
     * 错误码级别，例如 MODULE_LEVEL * moduleCode + code = 实际code
     */
    public static final Integer MODULE_LEVEL = 1000;
}
