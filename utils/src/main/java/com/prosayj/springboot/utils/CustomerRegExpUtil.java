package com.prosayj.springboot.utils;

import java.util.regex.Pattern;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/11/15 9:59
 * @since 1.0.0
 */
public class CustomerRegExpUtil {
    /**
     * 正则表达式：全文匹配数字
     */
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    /**
     * 正则表达式：邮箱格式
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    /**
     * 正则表达式：手机号
     */
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))(\\d{8})$");

    /**
     * 正则匹配是否都是数字
     *
     * @param str 待匹配字符串
     * @return true-是；false-不是
     */
    public static Boolean onlyNumber(String str) {
        return NUMBER_PATTERN.matcher(str).matches();
    }

    /**
     * 正则匹配是否都是数字
     *
     * @param str       待匹配字符串
     * @param minLength 校验长度下限（包含）
     * @param maxLength 校验长度上限（包含）
     * @return true-是；false-不是
     */
    public static Boolean onlyNumber(String str, int minLength, int maxLength) {
        if (Boolean.FALSE.equals(validationLength(str, minLength, maxLength))) {
            return Boolean.FALSE;
        }
        return NUMBER_PATTERN.matcher(str).matches();
    }

    /**
     * 正则匹配是否是邮箱格式
     *
     * @param str       待匹配字符串
     * @param minLength 校验长度下限（包含）
     * @param maxLength 校验长度上限（包含）
     * @return true-是；false-不是
     */
    public static Boolean validationEmail(String str, int minLength, int maxLength) {
        if (Boolean.FALSE.equals(validationLength(str, minLength, maxLength))) {
            return Boolean.FALSE;
        }
        return EMAIL_PATTERN.matcher(str).matches();
    }

    /**
     * @param phone
     * @description 正则匹配手机号
     * @author yangjian
     * @Date 15:14 2018/5/30
     * @since 1.0.0
     */
    public static Boolean validationPhone(String phone) {
        return MOBILE_PATTERN.matcher(phone).matches();
    }

    public static Boolean validationLength(String str, int minLength, int maxLength) {
        if (str == null) {
            return Boolean.FALSE;
        }
        if (str.length() < minLength || str.length() > maxLength) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
