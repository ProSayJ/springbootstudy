//package com.prosayj.springboot.security.browser;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author yangjian
// * @description TODO
// * @email ProSayJ@gmail.cn
// * @creatTime 2019/11/12 下午 12:26
// * @since 1.0.0
// */
//@Configuration
//public class BrowserSecurityConfig02 extends WebSecurityConfigurerAdapter {
//    @Override
//    /**
//     * 定义了哪些 URL 路径应该被拦截，如字面意思所描述：
//     * ”/“, “/home” 允许所有人访问，
//     * ”/login” 作为登录入口，
//     * 也被允许访问，而剩下的 “/hello” 则需要登陆后才可以访问
//     */
///*    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//
//                .and().logout().permitAll();
//        //关闭默认的csrf认证
//        http.csrf().disable();
//    }*/
//
//   // @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
////                .formLogin()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
//    }
//}
