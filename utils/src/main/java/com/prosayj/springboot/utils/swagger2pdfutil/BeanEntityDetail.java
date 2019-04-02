package com.prosayj.springboot.utils.swagger2pdfutil;

import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/2 10:02
 * @since 1.0.0
 */
public class BeanEntityDetail {
    /**
     * ��������
     */
    private String objectName;
    /**
     * ��������
     */
    private String objectType;

    /**
     * ��������+����
     * key��properties
     */
    private List<PropertiesDetail> properties;

    /**
     * ����Ĳ�����key����
     * @return
     */
    private List<String> requirePropertiesKeys;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public List<PropertiesDetail> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertiesDetail> properties) {
        this.properties = properties;
    }

    public List<String> getRequirePropertiesKeys() {
        return requirePropertiesKeys;
    }

    public void setRequirePropertiesKeys(List<String> requirePropertiesKeys) {
        this.requirePropertiesKeys = requirePropertiesKeys;
    }
}

