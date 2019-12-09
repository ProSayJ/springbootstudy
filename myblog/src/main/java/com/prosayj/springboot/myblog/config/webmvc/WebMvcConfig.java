package com.prosayj.springboot.myblog.config.webmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author yangjian
 * @description 资源拦截配置
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/20 11:36
 * @since 1.0.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    //解决中文乱码问题_start
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
    ////解决中文乱码问题_end


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);

//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页
        registry.addViewController("/index").setViewName("freemark/index");
        //文章详情
        registry.addViewController("/articedetail").setViewName("freemark/articedetail");
        //归档
        registry.addViewController("/archives").setViewName("freemark/archives");
        //分类
        registry.addViewController("/categories").setViewName("freemark/categories");
        //登陆
        registry.addViewController("/login").setViewName("login");
        //注册
        registry.addViewController("/register").setViewName("register");
        //新建文章
        registry.addViewController("/create").setViewName("redirect:/article/create");
        registry.addViewController("/example").setViewName("freemark/example");
        registry.addViewController("/article/register.html").setViewName("freemark/register");
    }
}