package adapter.blockchain.blockchain.service;

import adapter.blockchain.blockchain.AdapterBlockSDKUtil;
import adapter.blockchain.blockchain.config.RedisConfigMy;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.transaction.Transaction;
import cn.bubi.sdk.core.transaction.model.TransactionSerializable;
import cn.bubi.sdk.core.utils.SerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;

/**
 * @author yangjian
 * @description 交易提交测试用例
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/24 19:02
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {BCAutoConfiguration.class, BCAutoConfigurationSpi.class, RedisConfigMy.class})
public class _03_BlockChainOpreatorSubmit {
    @Autowired
    private BcOperationService bcOperationService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void submitTrans() {
        String hash = "ff2c79c8724243eee754fd6e958ab31efcaee65b8aa353daf7ebe0a02ad93ac9";
        String sign = "MIIFMgYJKoZIhvcNAQcCoIIFIzCCBR8CAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPrMIID5zCCAs+gAwIBAgIFEBCXckcwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDQ0OTM5WhcNMTkxMDIzMDQ0OTM5WjCBnjELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFRME8GA1UEAwxIMDQxQE45MTMyMDUwODM0NjM4NjM4NU5A6IuP5bee57yY5p2l5peg55WM5bel6Im65ZOB5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDANjmPzuBUf3bCeX090K3Y4SsSPbeklcQ3/LXSfBcVEuW8Y7nFgVLyfhONG8diimPtCOGzeieUeQflbSk9gvDuf1b0EbT7PR+vVe6sV8Vvq9gueRtmZ+9QsUdxcblSWb9wMPg2/zDRR9ytMSQ6hpzYVgWxm0I14hJr4t0+7TGj/QIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFFXco56p6W16FMVwjI5H9K4HWgE4MB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEANpenbl5r3LvS7ZRafmGxw2ArrFmZvSR20ALUZh8JETcD7vRUlBX+pcgtUg+zMl2E6Ir1WWsvm2n7mJd38WEwnRudWs6G8fj8xULNS32uAnUQrdwqRQDkv43Y3591vqHkNUfCT1Z/x7L0IV8M9XRkBHVPZYhShp8Ebm/KdnQF+m6KBJhGJkPZw8INcCdfaiJDNGNguboTnpO0/Q8TFuhbRDLMeH9LR+zTYmHd1VI+XGAfi7mvSGCNXuNVTl40HrA0DsYDs5eJtLIaj/obVItx/vih6aNQ3K43Wt/lRD8iBQfk8ZEtuEjcLUjJrR+q0x+NpjRSJZ8/h7riCuv5RklCZDGCAQswggEHAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JHMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIGAfcbzCHIGMdSH5ti/A4DlFPE5Vgc6wfkJwaUHpH4OVixf7rNM2T7BdCyCtO9dFWfkuTiX9JVyyzkx/EEIaFIg0XfVP/6HhcaxMEgedAsIQh+RPy9lHdAhmRHtBPKwwAlDpY5RuW25oATzOiWet6ZnoEICPpZFoaKNEIH4RSY+Ny0=";

        BlockchainKeyPair certBlockchainKeyPair = AdapterBlockSDKUtil.paseCertSignStr(sign);
        System.out.println("解析交易发起人的信息-通过证书签名结果获取：");
        System.out.println("证书公钥：" + certBlockchainKeyPair.getPubKey());
        System.out.println("证书地址：" + certBlockchainKeyPair.getBubiAddress());

        try {
            //SDK交易默认缓存在内存中，也可以通过配置缓存在redis中
            //Transaction transaction = TransactionContent.get(hash);
            //通过缓存中的hash获取交易：
            byte[] bytes = (byte[]) redisTemplate.opsForValue().get(hash);
            TransactionSerializable deserialize = SerializeUtil.deserialize(bytes);
            Transaction transaction = bcOperationService.continueTransaction(deserialize);
            //redisTemplate.delete(hash);
            System.out.println("获取缓存中的第一步交易-start:hash-" + transaction.toString());

            //操作人公钥和签名继续提交
            System.out.println("交易中添加发起人公钥：{" + certBlockchainKeyPair.getPubKey() + "}和签名{" + sign + "}的字节数组");
            System.out.println("提交底层交易-start:hash-" + hash);


            transaction.buildAddDigest(certBlockchainKeyPair.getPubKey(), sign.getBytes(Charset.forName("UTF-8"))).commit();


            System.out.println("提交底层交易-end:hash-{}" + hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
