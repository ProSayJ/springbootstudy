package adapter.blockchain.blockchain;

import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import org.springframework.util.Base64Utils;

import java.nio.charset.Charset;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/24 15:43
 * @since 1.0.0
 */
public class AdapterBlockSDKUtil {
    /**
     * CFCA_ukey签名解析ukey的区块链三元素
     * @param signStr
     * @return
     */
    public static BlockchainKeyPair paseCertSignStr(String signStr) {
        byte[] signBytes = signStr.getBytes(Charset.forName("UTF-8"));
        String base64SignStr = Base64Utils.encodeToString(signBytes);
        BlockchainKeyPair blockchainKeyPair = SecureKeyGenerator.generateCfcaAddress(base64SignStr);
        return blockchainKeyPair;
    }
}
