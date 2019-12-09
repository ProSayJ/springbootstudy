package com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * 包装一个对象所有的PropertyValue。<br/>
 * 为什么封装而不是直接用List?因为可以封装一些操作。
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 11:53
 * @since 1.0.0
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue pv) {
        //TODO:这里可以对于重复propertyName进行判断，直接用list没法做到
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }
}
