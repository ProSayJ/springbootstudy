title: Spring_Framework_Core_Technologies
author: ProSayJ
tags:
  - spring5
categories:
  - Spring Framework_5.2.0
date: 2019-03-05 15:30:00
---
<font color="blue">** 
Core Technologies
Version 5.2.0.BUILD-SNAPSHOT 
**</font>

This part of the reference documentation covers all the technologies that are absolutely integral to the Spring Framework.
<font color="blue">**
译：这部分参考文档涵盖了Spring Framework绝对不可或缺的所有技术。
**</font>

---
Foremost amongst these is the Spring Framework’s Inversion of Control (IoC) container. A thorough treatment of the Spring Framework’s IoC container is closely followed by comprehensive coverage of Spring’s Aspect-Oriented Programming (AOP) technologies. The Spring Framework has its own AOP framework, which is conceptually easy to understand and which successfully addresses the 80% sweet spot of AOP requirements in Java enterprise programming.
<font color="blue">**
译：其中最重要的是Spring Framework的控制反转（IoC）容器。 Spring框架的IoC容器的全面处理紧随其后，全面覆盖了Spring的面向方面编程（AOP）技术。 Spring Framework有自己的AOP框架，它在概念上易于理解，并且成功地解决了Java企业编程中AOP要求的80％最佳点。
**</font>

---
Coverage of Spring’s integration with AspectJ (currently the richest — in terms of features — and certainly most mature AOP implementation in the Java enterprise space) is also provided.
<font color="blue">**
译:还提供了Spring与AspectJ集成的覆盖范围（目前最丰富的 - 在功能方面 - 当然也是Java企业领域中最成熟的AOP实现）。
**</font>

# The IoC Container(IoC容器)
This chapter covers Spring’s Inversion of Control (IoC) container.
<font color="blue">**
译：本章介绍Spring的控制反转（IoC）容器。
**</font>

---
## Spring IoC容器和Bean简介

**1.1: Introduction to the Spring IoC Container and Beans**

This chapter covers the Spring Framework implementation of the Inversion of Control (IoC) principle. (See Inversion of Control.) IoC is also known as dependency injection (DI). It is a process whereby objects define their dependencies (that is, the other objects they work with) only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control) of the bean itself controlling the instantiation or location of its dependencies by using direct construction of classes or a mechanism such as the Service Locator pattern.
<font color="blue">**
译：本章介绍了控制反转（IoC）原理的Spring Framework实现。（参见控制反转。） IoC也称为依赖注入(DI)。 在这个过程中，对象仅通过构造方法参数、工厂方法的参数或者对象实例在构造实例化以后或通过工厂方法返回后设置的属性来定义它们的依赖项(即它们使用的其他对象)。 然后容器在创建bean时注入这些依赖项。 这个过程基本上是bean本身的逆过程(因此得名“控制反转”)，通过使用类的直接构造或服务定位器模式等机制来控制依赖关系的实例化或位置。
**</font>

---
The org.springframework.beans and org.springframework.context packages are the basis for Spring Framework’s IoC container. The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object. ApplicationContext is a sub-interface of BeanFactory. It adds:
<font color="blue">**
译：org.springframework.beans和org.springframework.context包是Spring框架的IoC容器的基础包。 BeanFactory 接口提供了一种能够管理任何类型对象的高级配置机制。 ApplicationContext 是BeanFactory的子接口。它补充说：
**</font>

---