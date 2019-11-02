package com.prosayj.springboot.utils.crypto.service.impl;

import com.prosayj.springboot.utils.crypto.algorithm.Sm4;
import com.prosayj.springboot.utils.crypto.service.CipherAlgorithm;
import com.prosayj.springboot.utils.crypto.vo.SecurityKeyInfo;
import org.slf4j.LoggerFactory;

/**
 * @author yangjian
 * @description
 * @Date 下午 07:58 2019/11/2
 * @since 1.0.0
 */
public class CipherAlgorithmSm4Impl implements CipherAlgorithm {


    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CipherAlgorithmSm4Impl.class);


    @Override
    public String decrypt(String cipherContent, SecurityKeyInfo keyInfo) throws Exception {
        return Sm4.decryptEcb(keyInfo.getKeyContent(), cipherContent);
    }

    @Override
    public String encrypt(String content, SecurityKeyInfo keyInfo) throws Exception {
        return Sm4.encryptEcb(keyInfo.getKeyContent(), content);
    }
}
