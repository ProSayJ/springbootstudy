package com.prosayj.springboot.myblogconfig.security;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/21 20:49
 * @since 1.0.0
 */
//@Configuration
//@EnableAuthorizationServer
//@EnableConfigurationProperties(AuthorizationServerProperties.class)
/*public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login.html")           // 设置登录页面
//                .loginProcessingUrl("/user/login")  // 自定义的登录接口
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/login.html").permitAll()     // 设置所有人都可以访问登录页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and().csrf().disable(); // 关闭csrf防护
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}*/
