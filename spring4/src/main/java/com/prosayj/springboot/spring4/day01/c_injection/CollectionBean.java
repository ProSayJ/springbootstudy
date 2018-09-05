package com.prosayj.springboot.spring4.day01.c_injection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionBean {
    /**
     * 数组类型注入
     */
    private Object[] arr;
    /**
     * list/set 类型注入
     */
    private List list;
    /**
     * map类型注入
     */
    private Map map;
    /**
     * properties类型注入
     */
    private Properties prop;

    public Object[] getArr() {
        return arr;
    }

    public void setArr(Object[] arr) {
        this.arr = arr;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }
}
