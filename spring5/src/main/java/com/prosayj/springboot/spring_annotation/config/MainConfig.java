package com.prosayj.springboot.spring_annotation.config;
/**
 * @description
 * @author yangjian
 * @Date 0:00 2018/9/25
 * @since 1.0.0
 */

import com.prosayj.springboot.spring_annotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类

@ComponentScans(
        value = {
                @ComponentScan(value = "com.prosayj.springboot.spring_annotation.bean", includeFilters = {
/*						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
                        @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})*/
                }, useDefaultFilters = false)
        }
)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {

    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    @Bean("person3")
    public Person person01() {
        return new Person("lisi", 20);
    }

}
