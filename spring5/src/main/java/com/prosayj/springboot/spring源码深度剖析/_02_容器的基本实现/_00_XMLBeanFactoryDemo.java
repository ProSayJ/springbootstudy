package com.prosayj.springboot.spring源码深度剖析._02_容器的基本实现;

import com.prosayj.springboot.spring_annotation.bean.Person;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class _00_XMLBeanFactoryDemo {
    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/prosayj/springboot/spring_annotation/beans.xml"));
        Person person = (Person)beanFactory.getBean("person");
        System.out.printf(person.toString());
    }
}
