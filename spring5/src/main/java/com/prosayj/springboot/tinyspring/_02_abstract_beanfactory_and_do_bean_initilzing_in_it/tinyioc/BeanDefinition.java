package com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc;

/**
 * @author yangjian
 * @description bean的容器
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:46
 * @since 1.0.0
 */
public class BeanDefinition {
    /**
     * 对象
     */
    private Object bean;

    /**
     * 对象的class
     */
    private Class beanClass;

    /**
     * 对象的名称
     */
    private String beanClassName;

    public BeanDefinition() {
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    /**
     * 反射通过bean类名获取的class
     *
     * @param beanClassName
     */
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
