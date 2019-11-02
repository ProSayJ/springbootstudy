package com.prosayj.springboot.utils.crypto.constants;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/29 下午 02:44
 * @since 1.0.0
 */
public class SensitiveInfoConstants {
    /**
     * 密文前缀中标识 3DES 3KEY
     */
    public static final String ENCRYPT_MARK_3DES_3KEY = "3DES3KEY_";

    /**
     * 密文前缀中标识 SM4
     */
    public static final String ENCRYPT_MARK_SM4 = "SM4_";
    /**
     * 密文前缀中，通用部分，可判断密文结尾
     */
    public static final String ENCRYPT_COMMON_MARK = "ENCRPYT_MARK_";

    public static final String[] DEFAULT_FIELDS = {""};
}
