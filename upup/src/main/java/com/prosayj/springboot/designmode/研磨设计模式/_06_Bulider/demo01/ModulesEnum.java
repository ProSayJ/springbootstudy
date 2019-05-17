/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.designmode.研磨设计模式._06_Bulider.demo01;

/**
 * @author wusonghui
 * @description 大原则：一个接口内的错误码保证唯一，不在全局保证错误码的唯一性。在同一个位置（base-core）
 * 中定义不同模块错误码枚举常量，以方便维护整个壹诺系统的错误码。
 * 常见错误类型为：参数过长，参数类型不正确，参数缺失，格式错误，权限不足
 * 根据错误码划分说明：
 * 1. 可扩展性：每个模块之间保留9个位置，为了方便以后有可能在模块中增加一些重要需要标识区分的子模块，
 * 预留了 680~ 899 后面扩展的壹诺大模块，预留900~999给布比平台服务的预留模块。
 * 2. 唯一性：项目唯一标识，定位问题。
 * 3. 风格一致，前三位是大模块编码，后三位是具体的错误码。
 * 4. 有相关的负责人，出现问题，更加方便定位、解决问题。
 * 5. 壹诺服务和调用平台服务区分，600-899为壹诺错误码，900-999为布比平台转义的错误码
 * 使用说明：
 * 模块编码(moduleCode)：主要提供给前端再翻译
 * 模块名称(moduleName)：后台需要输出系统模块名称的时候使用
 * 模块别称(moduleNickName)：可以使用在分模块的日志中使用，
 * 例如，LoggerFactory.getLogger(ModulesEnum.SYSTEM.moduleNickName());
 * @email wusonghui@bubi.cn
 * @creatTime 2017/11/24 15:43
 * @since 1.0.0
 */
public enum ModulesEnum {

    /**
     * 系统错误码
     * 模块码：500
     * 系统级别的错误码
     */
    SYSTEM(500, "系统错误码"),
    /**
     * 凭证管理
     * 模块码：600
     * 所有凭证相关操作如：凭证登记、提交审批、凭证签收、转让查询等
     */
    VOUCHER_MANAGEMENT(600, "凭证管理", "bunuo.voucher"),
    /**
     * 付款管理
     * 模块码：610
     * 付款全流程操作如：付款类型选择、付款申请、付款审批、付款查询等
     */
    PAYMENT_MANAGEMENT(610, "付款管理", "bunuo.pay"),
    /**
     * 授信管理
     * 模块码：620
     * 授信增、改、查
     */
    CREDIT_MANAGEMENT(620, "授信管理"),
    /**
     * 融资管理
     * 模块码：630
     * 凭证融资申请、审批
     */
    FINANCE_MANAGEMENT(630, "融资管理"),
    /**
     * 融资管理
     * 模块码：631
     * 凭证融资申请、审批
     */
    FINANCE_FUND_MANAGEMENT(631, "融资投资", "bunuo.financing"),
    /**
     * 证书管理
     * 模块码：640
     * 数字证书添加、绑定、查询、验证等
     */
    CERT_MANAGEMENT(640, "证书管理", "bunuo.center"),
    /**
     * 账户管理
     * 模块码：650
     * 员工创建、查询（企业创建的用户）
     */
    USER_MANAGEMENT(650, "账户管理", "bunuo.account"),
    /**
     * 企业管理
     * 模块码：660
     * 使用壹诺平台服务的企业：核心企业、供应商、资金方，创建、信息查询，含银行子账户创建、银行卡绑定等
     */
    COMPANY_MANAGEMENT(660, "企业管理", "bunuo.customer"),
    /**
     * 权限管理
     * 模块码：670
     * 权限配置及修改
     */
    PRIVILEGE_MANAGEMENT(670, "权限管理", "bunuo.security"),
    /**
     * 文件管理
     * 模块码：680
     * 文件存储
     */
    FILE_MANAGEMENT(680, "文件管理"),
    /**
     * 消息通知
     * 模块码：700
     * 融资申请、授信变更、放款
     */
    MESSAGE_NOTICE(700, "消息通知"),
    /**
     * 费用管理模块
     * 模块码：710
     */
    FEE_SERVICE(710, "费用管理服务"),
    /**
     * 权限管理
     * 模块码：720
     * 权限配置及修改
     */
    AUTH_MANAGEMENT(720, "鉴权中心"),
    /**
     * 运营模块
     * 模块码：730
     */
    OPS_SERVICE(730, "运维管理服务"),
    /**
     * 支付服务（含合约）
     * 模块码：850
     * 操作付款、充值、提现、融资放款、还款
     */
    PAYMENT_SERVICE(850, "支付服务（含合约）", "bunuo.adapter"),
    /**
     * 实名服务
     * 模块码：860
     * 实名验证等
     */
    REAL_NAME_SERVICE(860, "实名服务", "bunuo.adapter"),
    /**
     * 存证服务
     * 模块码：870
     * 合同及文件材料、等保时的数据存储等
     */
    WITNESS_SERVICE(870, "存证服务", "bunuo.adapter"),
    /**
     * 印章服务
     * 模块码：880
     * PDF文本、签章
     */
    SEAL_SERVICE(880, "印章服务", "bunuo.adapter"),
    /**
     * 消息服务
     * 模块码：890
     * 通知渠道（短信、邮件）
     */
    NOTICE_SERVICE(890, "消息服务", "bunuo.notice"),
    /**
     * 邀请码服务
     * 模块码：900
     * 邀请码创建分发
     */
    INVITE_SERVICE(900, "邀请码服务"),

    /**
     * 基础数据服务
     */
    BASEDATA_SERVICE(910, "基础数据服务"),

    /**
     * 控制台服务
     */
    CONSOLE_SERVICE(920,"控制台服务"),
 ;

    /**
     * 全系统 module code
     */
    private Integer moduleCode;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 模块别称
     */
    private String moduleNickName;

    ModulesEnum(Integer moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    ModulesEnum(Integer moduleCode, String moduleName, String moduleNickName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.moduleNickName = moduleNickName;
    }


    public Integer getModuleCode() {
        return moduleCode;
    }

    public String getModuleNickName() {
        return moduleNickName;
    }

    public String getModuleName() {
        return moduleName;
    }
}
