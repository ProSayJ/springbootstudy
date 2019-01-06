package com.prosayj.springboot.spring_annotation;

import java.util.Iterator;
import java.util.Map;

import com.prosayj.springboot.spring_annotation.bean.Blue;
import com.prosayj.springboot.spring_annotation.bean.Person;
import com.prosayj.springboot.spring_annotation.config.MainConfig;
import com.prosayj.springboot.spring_annotation.config.MainConfig2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;


public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = null;

    @Before
    public void init() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    }

//    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void testImport() {
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值
        Iterator<PropertySource<?>> iterator = environment.getPropertySources().iterator();
        iterator.forEachRemaining(data->{
            System.out.println(data.getName());
            Map<String, String> source = (Map<String, String>) data.getSource();
            source.entrySet().forEach(data2->{
                System.out.println(data2.getKey() + "<===>" + data2.getValue());
            });
        });
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);

    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//		String[] definitionNames = applicationContext.getBeanDefinitionNames();
//		for (String name : definitionNames) {
//			System.out.println(name);
//		}
//
        System.out.println("ioc容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }

    @SuppressWarnings("resource")
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
