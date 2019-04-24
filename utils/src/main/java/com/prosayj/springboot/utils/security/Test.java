package com.prosayj.springboot.utils.security;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.com
 * @creatTime 2018/11/29 21:44
 * @since 1.0.0
 */
public class Test {
    public static final int size = 1024;
    public static final String code_type = "UTF-8";

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "张三/李四/王五/123";
        System.out.println("密码原文==>" + str);

        //生成公私钥对
        RSAKeyPair rsaKeyPair = RSAUtils.generateKey(size);
        String pubKeyBase64Str = Base64.getEncoder().encodeToString(rsaKeyPair.getPublicKey());

        System.out.println("公钥==>" + pubKeyBase64Str);
        //公钥网络传输
        String pubKeyencode = URLEncoder.encode(pubKeyBase64Str, code_type);
        System.out.println("网络传输的公钥是==>" + pubKeyencode);

        String privKeyBase64Str = Base64.getEncoder().encodeToString(rsaKeyPair.getPrivateKey());
        System.out.println("私钥==>" + privKeyBase64Str);

        //公钥base64
        byte[] pubKeyDecode = Base64.getDecoder().decode(pubKeyBase64Str);
        //base64的公钥加密密文
        byte[] securityWordByte = RSAUtils.encryptByPublicKey(new String(str.getBytes(), code_type).getBytes(), pubKeyDecode);


        //密文网络传输
        String securityWord = Base64.getEncoder().encodeToString(securityWordByte);
        System.out.println("公钥加密以后的密文是==>" + securityWord);
        String securityWordEncode = URLEncoder.encode(securityWord, code_type);
        System.out.println("公钥加密以后的密文在网络传输==>" + securityWordEncode);

        //私钥可以存储在redis内部

        /**
         * 解密
         */
        //公钥网络还原
        String pubkeySrc = URLDecoder.decode(pubKeyencode, code_type);
        //通过公钥获取redis的私钥

        //密文网络还原
        String srcSecurityWordEncode = URLDecoder.decode(securityWordEncode, code_type);

        //密文解密
        byte[] resultByte = RSAUtils.decryptByPrivateKey(Base64.getDecoder().decode(srcSecurityWordEncode),
                Base64.getDecoder().decode(privKeyBase64Str));
        String result = new String(resultByte, Charset.forName("utf-8"));

        System.out.println(result);


    }
}
