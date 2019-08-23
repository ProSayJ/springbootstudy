package com.prosayj.springboot.customannotations;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/4 上午 09:56
 * @since 1.0.0
 */
public class AttachEmlement {

    // 普通
    public void AttachDefault(String name) {
        System.out.println("归属：" + name);
    }

    // 使用注解并传入参数
    @AttachAnnotation(paramValue = "注解设置的省")
    public void AttachAnnotation(String name) {
        System.out.println("归属：" + name);
    }

    // 使用注解并使用默认参数
    @AttachAnnotation
    public void AttachAnnotationDefault(String name) {
        System.out.println("归属：" + name);
    }
}
