/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.designmode.bulider.demo01;


/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/31 10:54
 * @since 1.0.0
 */
public enum MessageTypeEnum {
    /**
     * 供应商发起融资通知上级
     */
    FINANCING_APPLY(101, "供应商发起融资通知上級"),
    /**
     * 资金方放款通知凭证付上级
     */
    FINANCING_FUND(102, "资金方放款通知凭证付上級"),
    /**
     * 授信审批内容变更通知上级
     */
    CREDIT_GHANGE(103, "授信审批内容变更通知上級"),
    /**
     * 凭证文件导出通知当前用户
     */
    VOUCHER_EXPORT(104, "凭证文件导出通知当前用户"),
    /**
     * 凭证付款调账通知平台放
     */
    PAY_ADJUST(105, "凭证付款调账通知平台方"),

    /**
     * 资金方放款调账通知平台方
     */
    PAY_LOAN(106,"资金方放款调账通知平台方"),

    /**
     * 邀请企业通知运营方配置该企业费用
     */
    FEE_TOD_LIST(107, "邀请企业通知运营方配置该企业费用")
    ;

    private final int code;
    private final String description;
    /**
     * 模块
     */
    private ModulesEnum module = ModulesEnum.MESSAGE_NOTICE;

    MessageTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return module.getModuleCode() * ErrorCodeConstants.MODULE_LEVEL + code;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param code
     * @description 通过code获取枚举类
     * @author yangjian
     * @Date 11:46 2018/2/6
     * @since 1.0.0
     */
    public static MessageTypeEnum getByCode(int code) {
        for (MessageTypeEnum messageTypeEnum : MessageTypeEnum.values()) {
            if (code == messageTypeEnum.getCode()) {
                return messageTypeEnum;
            }
        }
        return null;
    }
}
