/*
 * Copyright (c) 2017-2022 布比（北京）网络技术有限公司.
 * All rights reserved.
 */

package com.prosayj.springboot.utils.security;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.util.Base64Utils;

/**
 * @author wangjingru
 * @description 编码方式转换
 * @email wangjingru@bubi.cn
 * @creatTime 2017/12/18 10:15
 * @since 1.0.0
 */
public class EncodeConverter {
    /**
     * 十六进制转base64编码
     * @param hexStr    待转换的十六进制字符串
     * @return
     */
    public static String hex2Base64(String hexStr) {
        return Base64Utils.encodeToString(Hex.decode(hexStr));
    }

    /**
     * base64编码转十六进制
     * @param base64Str 待转换的base64编码字符串
     * @return
     */
    public static String base642Hex(String base64Str) {
        return Hex.toHexString(base64Str.getBytes());
    }
}
