package com.prosayj.springboot.security.web.weblog.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;


/**
 * @author yangjian
 * @description 时间过滤器。该过滤器是不知道该请求是哪个controller的哪个方法去执行的。
 * 如果不使用@Component注解也可以使用javaConfig去配置
 * @Date 下午 06:26 2019/11/10
 * @since 1.0.0
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:" + (new Date().getTime() - start) + "毫秒");
        System.out.println("time filter finish");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("time filter init");
    }

}
