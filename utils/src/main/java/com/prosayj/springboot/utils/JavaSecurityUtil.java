package com.prosayj.springboot.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaSecurityUtil {
    public static void main(String[] args) {
        String hell0_world = base64Encoder("hell0 dasdasdsdasdasdworld", "UTF-8");
        System.out.println(hell0_world);
        System.out.println(base64Decode(hell0_world, "UTF-8"));
        System.out.println(toMD5("he"));

    }

    /**
     * 字符串base64编码
     *
     * @param msg
     * @param characrerSet
     * @return
     */
    public static String base64Encoder(String msg, String characrerSet) {
        String result = "";
        try {
            result = new BASE64Encoder().encode(msg.getBytes(characrerSet));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * base64解码
     *
     * @param base64Msg
     * @param characterSet
     * @return
     */
    public static String base64Decode(String base64Msg, String characterSet) {
        String reslut = "";
        try {
            reslut = new String(new BASE64Decoder().decodeBuffer(base64Msg), characterSet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reslut;

    }

    /**
     * msg 2 string
     *
     * @param msg
     * @return
     */
    public static String toMD5(String msg) {
        String result = "";
        try {
            MessageDigest md5Instance = MessageDigest.getInstance("MD5");
            md5Instance.update(msg.getBytes());
            byte[] digest = md5Instance.digest();

            BigInteger bigInteger = new BigInteger(digest);
            result = bigInteger.toString(16).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
