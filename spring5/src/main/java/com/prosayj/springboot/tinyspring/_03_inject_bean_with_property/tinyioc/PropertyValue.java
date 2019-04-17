package com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc;

/**
 * @author yangjian
 * @description 用于bean的属性注入
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 11:52
 * @since 1.0.0
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
