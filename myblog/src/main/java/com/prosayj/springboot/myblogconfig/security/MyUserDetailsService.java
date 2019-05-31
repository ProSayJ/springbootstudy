package com.prosayj.springboot.myblogconfig.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/21 20:52
 * @since 1.0.0
 */
//@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 根据用户名，查找到对应的密码，与权限
        String password = passwordEncoder.encode("123456");

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }


}
