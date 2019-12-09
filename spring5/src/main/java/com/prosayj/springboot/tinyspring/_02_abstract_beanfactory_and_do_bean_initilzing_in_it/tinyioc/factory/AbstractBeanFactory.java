package com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.factory;

import com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:49
 * @since 1.0.0
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * 初始化bean
     *
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

}
