package com.prosayj.springboot.utils.swagger2pdfutil;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/2 11:00
 * @since 1.0.0
 */
class PropertiesKeyDes {
    private boolean require;
    private String type;
    private String format;
    private String description;

    public boolean isRequire() {
        return require;
    }

    public void setRequire(boolean require) {
        this.require = require;
    }

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
}
