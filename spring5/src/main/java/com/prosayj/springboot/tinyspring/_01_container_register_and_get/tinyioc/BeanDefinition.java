package com.prosayj.springboot.tinyspring._01_container_register_and_get.tinyioc;

/**
 * @author yangjian
 * @description Bean定义
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:35
 * @since 1.0.0
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    /**
     * 获取bean对象实例
     * @return
     */
    public Object getBean() {
        return bean;
    }
}
