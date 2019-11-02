package com.prosayj.springboot.utils.crypto.service;


import com.prosayj.springboot.utils.crypto.vo.SecurityKeyInfo;

/**
 * @description 加解密接口类，不同的加密方式，加密途径类请实现此接口
 * @author yangjian
 * @Date 下午 02:59 2019/10/29
 * @since 1.0.0
 */
public interface CipherAlgorithm {


    /**
     * decrypt
     *
     * @param cipherContent 密文
     * @param keyInfo       秘钥信息
     * @return
     * @throws Exception
     */
    String decrypt(String cipherContent, SecurityKeyInfo keyInfo) throws Exception;

    /**
     * encrypt
     *
     * @param content 明文
     * @param keyInfo 秘钥信息
     * @return
     * @throws Exception
     */
    String encrypt(String content, SecurityKeyInfo keyInfo) throws Exception;
}
