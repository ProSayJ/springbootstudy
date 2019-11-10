package com.prosayj.springboot.utils.crypto.test;

import com.prosayj.springboot.utils.FileUtils;
import com.prosayj.springboot.utils.crypto.util.SensitiveInfoUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/29 下午 02:54
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("zhangsan","子主题 5ds");
        map.put("sdads","子主题 5asd");
        map.put("212","子主题 as");

        map.forEach((key,value)->{
            System.out.println("key = " + key);
            System.out.println("value = " + value);
        });



        //加密
        //System.out.println(SensitiveInfoUtils.smartEncrypt("157841578415784"));
        //解密
        System.out.println(SensitiveInfoUtils.smartDecryptWithCheck("3DES3KEY_ENCRPYT_MARK_OYkConhPHnIxY30Q4wHHTdOVkNOTRJp1RAgU9uLXfD0"));

    }
}
