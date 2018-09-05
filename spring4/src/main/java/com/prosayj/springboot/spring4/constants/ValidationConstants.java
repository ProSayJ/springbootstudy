
/**
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.spring4.constants;

/**
 * @description
 * @author yangjian
 * @Date 10:33 2018/8/8
 * @since 1.0.0
 */
public class ValidationConstants {
    /**
     * 字符串无产品需求限制时，统一长度限制
     */
    public static final int STRING_LENGTH_MAX = 255;
    /**
     * 企业全称长度上限：100
     */
    public static final int COMPANY_NAME_LENGTH_MAX = 100;

    /**
     * 地址长度上限：100
     */
    public static final int ADDRESS_LENGTH_MAX = 100;
    /**
     * 手机号长度上限：20
     */
    public static final int PHONE_LENGTH_MAX = 20;
    /**
     * 证件号码长度上限：30
     */
    public static final int CERTIFICATE_CODE_LENGTH_MAX = 30;
    /**
     * 城市长度下限：1
     */
    public static final int CITY_LENGTH_MIN = 1;
    /**
     * 城市长度上限：50
     */
    public static final int CITY_LENGTH_MAX = 50;
    /**
     * 备注长度上限：50
     */
    public static final int COMPANY_REMARK_LENGTH_MAX = 50;
    /**
     * 企业名称长度最大值:255
     */
    public static final int COMPANY_NAME_MAX_SIZE = 255;
    /**
     * 用户名称长度最大值:255
     */
    public static final int USER_NAME_MAX_SIZE = 255;
    /**
     * 原因长度最大值:255
     */
    public static final int REASON_MAX_SIZE = 255;
    /**
     * 原因长度最大值:500
     */
    public static final int REASON_MAX_SIZE_500 = 500;

    /**
     * 虚账户动账金额上限：9999999999999L
     */
    public static final long PAY_VALUE_MAX = 9999999999999L;
    /**
     * 虚账户动账金额下限：0
     */
    public static final long PAY_VALUE_MIN = 0L;
    /**
     * 人类姓名全称上限（联系人姓名、法人姓名等）:20
     */
    public static final int FULL_NAME_MAX = 20;
    /**
     * 密码长度下限：8
     */
    public static final int PASSWORD_LENGTH_MIN = 8;
    /**
     * 密码长度上限：20
     */
    public static final int PASSWORD_LENGTH_MAX = 20;
    /**
     * 手机号最大长度：20
     */
    public static final int PHONE_MAX = 20;

    public static final int PARAM_LENGTH = 100;
}
