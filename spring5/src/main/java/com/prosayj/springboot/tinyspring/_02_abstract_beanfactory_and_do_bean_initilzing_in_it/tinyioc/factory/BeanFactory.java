package com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.factory;

import com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.BeanDefinition;

/**
 * @author yangjian
 * @description BeanFactory 接口
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:45
 * @since 1.0.0
 */
public interface BeanFactory {
    /**
     * 获取对象：通过对象名称
     * @param name
     * @return
     */
    Object getBean(String name);
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
