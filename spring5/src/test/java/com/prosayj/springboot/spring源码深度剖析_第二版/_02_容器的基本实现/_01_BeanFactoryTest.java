package com.prosayj.springboot.spring源码深度剖析_第二版._02_容器的基本实现;

import com.prosayj.springboot.spring源码深度剖析._02_容器的基本实现.MyTestBean;
import com.prosayj.springboot.spring源码深度剖析.第5章_bean的加载.Car;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author yangjian
 * @description
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/9 上午 12:49
 * @since 1.0.0
 */
@SuppressWarnings("deprecation")
public class _01_BeanFactoryTest {


    /**
     * 检查缓存中或者实例工厂中是否有对应的实例
     * 会为什么首先会使用这段代码呢？
     * 因为在创建单例bean的时候会存在依赖注入的情况，而在创建依赖的时候为了避免循环依赖，
     * Spring创建bean的原则是不等bean创建完成就将创建bean的ObjectFactory提早曝光
     * 也就是将ObjctFactory加入到缓存中，一旦下一个bean创建的时候要依赖上一个bean则直接使用ObjectFactory
     */
    @Test
    public void testSimpleLoad() throws IOException {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/prosayj/springboot/spring源码深度剖析/_02_容器的基本实现/beanFactoryTest.xml"));
        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());


        Car car = (Car)beanFactory.getBean("car");
        System.out.println(car.toString());

//        ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");
//        InputStream inputStream = resource.getInputStream();

    }



}
