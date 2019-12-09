package com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc;

import com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.factory.AutowireCapableBeanFactory;
import com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.factory.BeanFactory;
import org.junit.Test;

/**
 * @author yihua.huang@dianping.com
 */
public class BeanFactoryTest {

	@Test
	public void test() throws Exception {
		// 1.初始化beanfactory
		BeanFactory beanFactory = new AutowireCapableBeanFactory();

		// 2.bean定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("com.prosayj.springboot.tinyspring._03_inject_bean_with_property.tinyioc.HelloWorldService");

		// 3.设置属性
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "Hello World!!!!"));
        beanDefinition.setPropertyValues(propertyValues);

		// 4.生成bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

		// 5.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();

	}
}
