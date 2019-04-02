package com.prosayj.springboot.utils.swagger2pdfutil;

import java.util.List;

public class ResponstParamsDes {
    /**
     * 参数类型
     */
    private String type;
    /**
     * 格式化
     */
    private String format;

    /**
     * 参数描述
     */
    private String description;

    /**
     * 必填的字段
     */
    private List<String> required;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }

}
