package com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc;

import com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.factory.AutowireCapableBeanFactory;
import com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 10:11
 * @since 1.0.0
 */
public class BeanFactoryTest {
    @Test
    public void test() {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.prosayj.springboot.tinyspring._02_abstract_beanfactory_and_do_bean_initilzing_in_it.tinyioc.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }
}
