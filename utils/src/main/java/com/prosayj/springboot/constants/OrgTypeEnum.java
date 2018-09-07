/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:企业类型枚举
 * @author: kevinks.cao@gmail.com
 * @email: caowukui@bubi.cn
 * @createTime: 2018/3/7 14:48
 * @since: 1.0.0
 */
public enum OrgTypeEnum {

    /**
     * 平台方
     */
    PLATFORM(0, "平台方"),

    /**
     * 运营方
     */
    OPERATOR(1, "运营方"),

    /**
     * 核心企业
     */
    CORE(2, "核心企业"),

    /**
     * 渠道
     */
    CHANNEL(3, "渠道"),

    /**
     * 资金方
     */
    FINANCE(4, "资金方"),

    /**
     * 供应商
     */
    SUPPLIER(5, "供应商"),

    /**
     * 担保方
     */
    GUARANTEE(6, "担保方"),;

    private final int id;

    private final String desc;

    private OrgTypeEnum(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    private final static Map<Integer, OrgTypeEnum> maps = new HashMap<>();

    static {
        for (OrgTypeEnum orgTypeEnum : values()) {
            maps.put(orgTypeEnum.getId(), orgTypeEnum);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

    public static OrgTypeEnum findById(int id) {
        switch (id) {
            case 0:
                return OrgTypeEnum.PLATFORM;
            case 1:
                return OrgTypeEnum.OPERATOR;
            case 2:
                return OrgTypeEnum.CORE;
            case 3:
                return OrgTypeEnum.CHANNEL;
            case 4:
                return OrgTypeEnum.FINANCE;
            case 5:
                return OrgTypeEnum.SUPPLIER;
            default:
                break;
        }

        return null;
    }

    public static OrgTypeEnum findByName(String name) {
        for (OrgTypeEnum orgTypeEnum : values()) {
            if (orgTypeEnum.toString().equals(name)) {
                return orgTypeEnum;
            }
        }
        return null;
    }

    public static OrgTypeEnum paseStr(String str) {
        OrgTypeEnum orgTypeEnum = null;
        for (Integer key : maps.keySet()) {
            String string = maps.get(key).toString();
            if (string.equals(str)) {
                orgTypeEnum = findById(key);
                break;
            }
        }
        return orgTypeEnum;
    }

    public static void main(String[] args) {
        System.out.println(findByName("FINANCE1"));
        System.out.println(paseStr("FINANCE1"));
    }
}
