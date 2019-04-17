package com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.factory;


import com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.BeanDefinition;

/**
 * @author yangjian
 * @description bean的容器
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:45
 * @since 1.0.0
 */
public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;


}
