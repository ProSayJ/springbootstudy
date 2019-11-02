package com.prosayj.springboot.utils.crypto.factoty;

import com.prosayj.springboot.utils.crypto.constants.EncryptType;
import com.prosayj.springboot.utils.crypto.constants.SensitiveInfoConstants;
import com.prosayj.springboot.utils.crypto.service.CipherAlgorithm;
import com.prosayj.springboot.utils.crypto.service.impl.CipherAlgorithm3DesImp;
import com.prosayj.springboot.utils.crypto.service.impl.CipherAlgorithmSm4Impl;
import com.prosayj.springboot.utils.crypto.vo.SecurityKeyInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/29 下午 02:45
 * @since 1.0.0
 */
public class AlgorithmFactory {

    private static Map<EncryptType, CipherAlgorithm> algorithm = new HashMap<>();

    static {
        algorithm.put(EncryptType.THREE_DES_THREE_KEYS, new CipherAlgorithm3DesImp());
        algorithm.put(EncryptType.SM4, new CipherAlgorithmSm4Impl());
    }

    public static CipherAlgorithm getInstance(EncryptType encryptType) {
        return algorithm.get(encryptType);
    }


    private static Map<EncryptType, SecurityKeyInfo> securityKeyInfoMap = new HashMap<>();

    static {
        securityKeyInfoMap.put(EncryptType.THREE_DES_THREE_KEYS, get3DESKeyInfo());
        securityKeyInfoMap.put(EncryptType.SM4, getSM4KeyInfo());
    }

    public static SecurityKeyInfo getInstance(String encryptType) {
        return securityKeyInfoMap.get(EncryptType.valueOf(encryptType));
    }


    public static SecurityKeyInfo get3DESKeyInfo() {
        SecurityKeyInfo securityKeyInfo = new SecurityKeyInfo();
        securityKeyInfo.setKeyVersion("V1.0");
        securityKeyInfo.setEncryptType(EncryptType.THREE_DES_THREE_KEYS);
        securityKeyInfo.setKeyContent("6CFnVDf7UGbar88vR6SQWA==");
        securityKeyInfo.setPrefix(SensitiveInfoConstants.ENCRYPT_MARK_3DES_3KEY + SensitiveInfoConstants.ENCRYPT_COMMON_MARK);
        return securityKeyInfo;
    }


    public static SecurityKeyInfo getSM4KeyInfo() {
        SecurityKeyInfo securityKeyInfo = new SecurityKeyInfo();
        securityKeyInfo.setKeyVersion("V1.0");
        securityKeyInfo.setEncryptType(EncryptType.SM4);
        securityKeyInfo.setPrefix(SensitiveInfoConstants.ENCRYPT_MARK_SM4 + SensitiveInfoConstants.ENCRYPT_COMMON_MARK);
        return securityKeyInfo;
    }
}
