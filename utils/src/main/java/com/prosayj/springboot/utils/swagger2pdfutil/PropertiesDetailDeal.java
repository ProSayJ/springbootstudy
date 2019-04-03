package com.prosayj.springboot.utils.swagger2pdfutil;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/2 11:00
 * @since 1.0.0
 */
class PropertiesDetailDeal implements Serializable{

    private static final long serialVersionUID = -4088426071226404309L;
    private String propertiesKey;
    private Boolean require;
    private String type;
    private String format;
    private String description;

    public String getPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(String propertiesKey) {
        this.propertiesKey = propertiesKey;
    }

    public Boolean getRequire() {
        return require;
    }

    public void setRequire(Boolean require) {
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

    @Override
    public String toString() {
        return "PropertiesDetailDeal{" +
                "propertiesKey='" + propertiesKey + '\'' +
                ", require=" + require +
                ", type='" + type + '\'' +
                ", format='" + format + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
