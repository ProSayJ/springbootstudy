package com.prosayj.springboot.utils.swagger2pdfutil;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/2 11:00
 * @since 1.0.0
 */
class PropertiesDetail {
    private String propertiesKey;
    private PropertiesKeyDes propertiesKeyDes;

    public String getPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(String propertiesKey) {
        this.propertiesKey = propertiesKey;
    }

    public PropertiesKeyDes getPropertiesKeyDes() {
        return propertiesKeyDes;
    }

    public void setPropertiesKeyDes(PropertiesKeyDes propertiesKeyDes) {
        this.propertiesKeyDes = propertiesKeyDes;
    }
}
