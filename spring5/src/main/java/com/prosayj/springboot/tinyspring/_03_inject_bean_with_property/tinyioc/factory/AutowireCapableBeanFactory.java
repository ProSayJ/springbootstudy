package com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.factory;

import com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.BeanDefinition;
import com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author yangjian
 * @description 可自动装配内容的BeanFactory
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 11:51
 * @since 1.0.0
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
        for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
