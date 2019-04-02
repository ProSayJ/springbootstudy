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
public class BeanEntityDetailTest {
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
    private List<PropertiesDetail> properties;


    class PropertiesDetail {
        private String propertiesKey;
        private List<PropertiesKeyDes> propertiesKeyDes;
    }

    class PropertiesKeyDes {
        private String type;
        private String format;
        private String description;

    }
}

