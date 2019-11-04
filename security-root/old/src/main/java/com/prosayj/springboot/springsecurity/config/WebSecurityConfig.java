package com.prosayj.springboot.springsecurity.config;

/**
 * @author yangjian
 * @description
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/30 上午 08:47
 * @since 1.0.0
 */

import com.prosayj.springboot.springsecurity.bean.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
/**
 * https://github.com/spring-guides/gs-securing-web.git
 *  @EnableWebSecurity 注解使得 SpringMVC 集成了 Spring Security 的 web 安全支持。
 *  另外，WebSecurityConfig 配置类同时集成了 WebSecurityConfigurerAdapter，重写了其中的特定方法，用于自定义 Spring Security 配置。
 *  整个 Spring Security 的工作量，其实都是集中在该配置类，不仅仅是这个 guides，实际项目中也是如此。
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        new Thread(()->{

        }).start();
    }

    @Override
    /**
     * 定义了哪些 URL 路径应该被拦截，如字面意思所描述：
     * ”/“, “/home” 允许所有人访问，
     * ”/login” 作为登录入口，
     * 也被允许访问，而剩下的 “/hello” 则需要登陆后才可以访问
     */
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login").permitAll()

                .and().logout().permitAll();
        //关闭默认的csrf认证
        http.csrf().disable();
    }

    @Autowired
    /**
     *  在内存中配置一个用户，admin/admin 分别是用户名和密码，这个用户拥有 USER 角色。
     */
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("admin").password("admin").roles("USER");
    }

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        //.passwordEncoder(new MyPasswordEncoder())。
        //这样，页面提交时候，密码以明文的方式进行匹配。
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("user").password("user").roles("ADMIN");
    }*/

    @Override
    public void configure(WebSecurity web) {
        //设置静态资源不要拦截
        web.ignoring().antMatchers("/js/**", "/cs/**", "/images/**");
    }
}