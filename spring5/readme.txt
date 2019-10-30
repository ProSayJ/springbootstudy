1:bean的生命周期

2：IOC容器是如何解决循环依赖的？


3：spring的哪种循环依赖是不能解决的？为什么不能解决？

创建  初始化  销毁 ... ...

InstanceA bean = applicationContext.getBean(InstanceA.class);

org.springframework.context.support.AbstractApplicationContext.getBean(java.lang.Class<T>)
    org.springframework.context.support.GenericApplicationContext.getBeanFactory
        org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(java.lang.Class<T>)
            org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(java.lang.Class<T>, java.lang.Object...)
                org.springframework.core.ResolvableType.forRawClass
                    org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveBean
                        org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(org.springframework.core.ResolvableType, java.lang.Object[], boolean)
                            org.springframework.beans.factory.support.AbstractBeanFactory.getBean(java.lang.String, java.lang.Class<T>, java.lang.Object...)
                                org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean
                                    org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(java.lang.String)
                                        org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(java.lang.String, boolean)
                                            org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getObjectForBeanInstance
                                                org.springframework.beans.factory.support.AbstractBeanFactory.getObjectForBeanInstance
                                                    org.springframework.beans.factory.support.AbstractBeanFactory.getObjectForBeanInstance























