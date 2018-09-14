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
    PROSAYJ_JAVASE(1, "java模块日志", "prosayj.javase"),
    PROSAYJ_MAIN(2, "main模块日志", "prosayj.main"),
    PROSAYJ_SPRING5(3, "main模块日志", "prosayj.spring5"),
    PROSAYJ_UPUP(4, "upup模块日志", "prosayj.upup"),
    PROSAYJ_WEB(5, "web模块日志", "prosayj.web"),
    PROSAYJ_UTILS(5, "utils模块日志", "prosayj.utlis"),



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
