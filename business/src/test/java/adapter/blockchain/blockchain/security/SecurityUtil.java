package adapter.blockchain.blockchain.security;


import com.prosayj.springboot.utils.security.RSAUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/31 下午 02:56
 * @since 1.0.0
 */
public class SecurityUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {
        RSAUtils.publickeyEncryptionAndPrivateKeyDecryption("你好",null);
    }

}
