package com.prosayj.springboot.constants;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/10 11:54
 * @since 1.0.0
 */
public enum LoggerModelEnum {
    PROSAYJ_BLOCKCHAIN(0, "blockchain模块日志", "prosayj.blockchain"),
    PROSAYJ_BUSINESS(1, "business模块日志", "prosayj.business"),
    PROSAYJ_EVENT(2, "event模块日志", "prosayj.event"),
    PROSAYJ_JAVASE(3, "javase模块日志", "prosayj.javase"),
    PROSAYJ_MAIN(4, "main模块日志", "prosayj.main"),
    PROSAYJ_SPRING5(5, "spring5模块日志", "prosayj.spring5"),
    PROSAYJ_UPUP(6, "upup模块日志", "prosayj.upup"),
    PROSAYJ_UTILS(6, "utils模块日志", "prosayj.utlis"),


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

    LoggerModelEnum(Integer moduleCode, String moduleName, String moduleNickName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.moduleNickName = moduleNickName;
    }

    public Integer getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(Integer moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleNickName() {
        return moduleNickName;
    }

    public void setModuleNickName(String moduleNickName) {
        this.moduleNickName = moduleNickName;
    }
}

