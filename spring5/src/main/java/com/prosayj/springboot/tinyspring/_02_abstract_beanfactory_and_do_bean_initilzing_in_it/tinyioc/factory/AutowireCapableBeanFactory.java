package com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.factory;

import com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.BeanDefinition;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:51
 * @since 1.0.0
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object bean = beanDefinition.getBeanClass().newInstance();
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
