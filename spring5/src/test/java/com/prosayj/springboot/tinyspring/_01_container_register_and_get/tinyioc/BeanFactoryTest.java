package com.prosayj.springboot.tinyspring._01_container_register_and_get.tinyioc;

import org.junit.Test;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/17 9:37
 * @since 1.0.0
 */
public class BeanFactoryTest {
    @Test
    public void test() {
        // 1.初始化beanfactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();


    }
}
