package com.prosayj.springboot.utils.crypto.constants;

import java.io.Serializable;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/29 下午 02:43
 * @since 1.0.0
 */
public enum EncryptType implements Serializable {
    /**
     * 3DES 3key 加密
     */
    THREE_DES_THREE_KEYS,
    /**
     * 国密4
     */
    SM4;
}
