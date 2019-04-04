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
public class BeanEntityDetailDeal {
    /**
     * 对象名称
     */
    private String objectName;
    /**
     * 对象类型
     */
    private String objectType;

    /**
     * 对象属性+类型
     * key：properties
     */
//    private List<PropertiesDetailDeal> propertiesDeals;

    /**
     * key为属性名称
     * 内部的map为属性的其他详细描述
     */
    private Map<String, Map<String, Object>> propertiesDeals;

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

    public Map<String, Map<String, Object>> getPropertiesDeals() {
        return propertiesDeals;
    }

    public void setPropertiesDeals(Map<String, Map<String, Object>> propertiesDeals) {
        this.propertiesDeals = propertiesDeals;
    }
}

