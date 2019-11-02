package com.prosayj.springboot.utils.crypto.test;

import com.prosayj.springboot.utils.crypto.util.SensitiveInfoUtils;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/29 下午 02:54
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        //加密
        System.out.println(SensitiveInfoUtils.smartEncrypt("157841578415784"));
        //解密
        System.out.println(SensitiveInfoUtils.smartDecryptWithCheck("3DES3KEY_ENCRPYT_MARK_mTj63nmlJMyEUbuAvEOdYg=="));
    }
}
