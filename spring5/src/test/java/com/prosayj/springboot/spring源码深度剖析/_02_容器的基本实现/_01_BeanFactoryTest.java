package com.prosayj.springboot.spring源码深度剖析._02_容器的基本实现;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.CollectionUtils;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/9 上午 12:49
 * @since 1.0.0
 */
@SuppressWarnings("deprecation")
public class _01_BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        XmlBeanFactory beanFactory = new XmlBeanFactory(
                new ClassPathResource("com/prosayj/springboot/spring源码深度剖析/_02_容器的基本实现/beanFactoryTest.xml"));
        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());
    }


}
