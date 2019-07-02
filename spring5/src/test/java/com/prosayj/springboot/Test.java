package com.prosayj.springboot;

import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/2 下午 02:29
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
public class Test {
    @org.junit.Test
    public void getPass() {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //加密盐
        encryptor.setPassword("dev");
        //用户名
        String name = encryptor.encrypt("root");
        System.out.println(name);//fiID7oXNRffApnQFBhkEyg==
        //密码
        String password = encryptor.encrypt("cem");
        System.out.println(password);//jjnRi0fBeo7ycdO36JSMFw==


        //解密
        EnvironmentStringPBEConfig environmentStringPBEConfig = new EnvironmentStringPBEConfig();
        environmentStringPBEConfig.setPassword("dev");
        environmentStringPBEConfig.setAlgorithm("PBEWithMD5AndDES");
        environmentStringPBEConfig.setPasswordEnvName("APP_ENCRYPTION_PASSWORD");


    }
}
