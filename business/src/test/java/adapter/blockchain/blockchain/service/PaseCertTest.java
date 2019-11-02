package adapter.blockchain.blockchain.service;

import adapter.blockchain.blockchain.config.RedisConfig;
import cn.bubi.access.adaptation.blockchain.bc.OperationTypeV3;
import cn.bubi.access.adaptation.blockchain.bc.RpcService;
import cn.bubi.access.adaptation.blockchain.bc.response.TransactionHistory;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import cn.bubi.sdk.core.exception.SdkException;
import cn.bubi.sdk.core.operation.impl.CreateAccountOperation;
import cn.bubi.sdk.core.operation.impl.SetMetadataOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.transaction.model.TransactionCommittedResult;
import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description 区块链数据模拟
 * @creatTime 2018/4/24 18:37
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {BCAutoConfiguration.class, BCAutoConfigurationSpi.class, RedisConfig.class})
public class PaseCertTest {
    @Autowired
    private BcOperationService operationService;
    @Autowired
    private RpcService rpcService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    //企业实名第一步：创建企业主体的区块链地址和公钥私钥和地址：
    /**
     * 现实业务：
     * 实名的时候：
     * 将第一个证书账户地址添加到企业主体所在区块链账户的签名列表里面
     */

   /*  @Test
   public void createCompany() {
        pastCert();
        createCompanyByAccountPool();
        createCompanyByUser();
    }*/

    /**
     * 创建账户
     */

    //  @Test
//    public void createAccount() {
//        //新创建企业主体三元素：公钥、私钥、区块链地址
//        BlockchainKeyPair newCompany = SecureKeyGenerator.generateBubiKeyPair();
//        String newCompanyBubiAddress = newCompany.getBubiAddress();
//        String newCompanyPriKey = newCompany.getPriKey();
//        String newCompanyPubKey = newCompany.getPubKey();
//        try {
//            CreateAccountOperation createAccountOperation = new CreateAccountOperation.Builder()
//                    .buildDestAddress(newCompanyBubiAddress)
//                    .buildScript("function main(input) { /*do what ever you want*/ }")
//                    .buildAddMetadata("boot自定义key1", "boot自定义value1")
//                    .buildAddMetadata("boot自定义key2", "boot自定义value2")
//                    // 权限部分
//                    .buildPriMasterWeight(15)
//                    .buildPriTxThreshold(15)
//                    /**
//                     * 1 CREATE_ACCOUNT 创建账号
//                     * 2 ISSUE_ASSET 发行资产
//                     * 3 PAYMENT 转移资产
//                     * 4 SET_METADATA 设置metadata
//                     * 5 SET_SIGNER_WEIGHT 设置权重
//                     * 6 SET_THRESHOLD 设置门限
//                     */
//                    .buildAddPriTypeThreshold(OperationTypeV3.CREATE_ACCOUNT, 8)
//                    .buildAddPriTypeThreshold(OperationTypeV3.SET_METADATA, 6)
//                    .buildAddPriTypeThreshold(OperationTypeV3.ISSUE_ASSET, 4)
//                    .buildAddPriSigner("Signer---Signer", 10)
//                    .buildOperationMetadata("操作metadata")// 这个操作应该最后build
//                    .build();
//
//
//            // 可以拿到blob,让前端签名
//            TransactionBlob blob = operationService.newTransaction(newCompanyBubiAddress)
//                    .buildAddOperation(createAccountOperation)
//                    // 调用方可以在这里设置一个预期的区块偏移量，1个区块偏移量=3秒或1分钟，可以用3s进行推断，最快情况1分钟=20个区块偏移量
//                    .buildFinalNotifySeqOffset(Transaction.HIGHT_FINAL_NOTIFY_SEQ_OFFSET)
//                    .generateBlob();
//
//            try {
//                // 模拟用户操作等待
//                TimeUnit.SECONDS.sleep(65);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//            // 签名完成之后可以继续提交,需要自己维护transaction保存
//            TransactionCommittedResult result = operationService.newTransaction(newCompanyBubiAddress)
//                    .buildAddSigner(CREATOR_PUBLIC_KEY, CREATOR_PRIVATE_KEY)
//                    //.buildAddDigest("公钥",new byte[]{}) 可以让前端的签名在这里加进来
//                    .commit();
//            resultProcess(result, "创建账号状态:");
//
//        } catch (SdkException e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * 解析证书：解析签名cfca加密ukey后的地址：
     */
    @Test
    public void pastCert() {
        /**
         * 证书的基本信息：C:\java_soft\v3.4.0.1\程序\Demo\MsgSign.html
         企业名称：苏州缘来无界工艺品有限公司
         private String name;

         //统一社会信用证代码：91320508346386385N
         private String companyCode;

         //证书序列号：1010977247
         private String serialNo;

         //证书发行者DN：CN=041@N91320508346386385N@苏州缘来无界工艺品有限公司@00000001, OU=Enterprises, OU=BUBI, O=CFCA TEST OCA1, C=cn
         private String issuerDn;

         //证书主题Cn：041@N91320508346386385N@苏州缘来无界工艺品有限公司@00000001
         private String subjectCn;

         //前端的签名串：前端使用:统一社会信用证代码来生成base64串：签名demo选择：PKCS#7不带原文签名
         private String signStr;
         MIIFOgYJKoZIhvcNAQcCoIIFKzCCBScCAQExCzAJBgUrDgMCGgUAMCEGCSqGSIb3DQEHAaAUBBI5MTMyMDUwODM0NjM4NjM4NU6gggPlMIID4TCCAsmgAwIBAgIFEBCXclEwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDUyMDU5WhcNMTkxMDIzMDUyMDU5WjCBmDELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFLMEkGA1UEAwxCMDQxQE45MTM0MDg4MTY3NDIzMDA4MFVA5a6J5b695pe65p2l5peg57q65biD5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjz3skGnkEQljL4/yAhpiiRO1pKOiwx0sbm8WrRRmmUiTsXsrtJMWP782nWNv27EVPS7rLOgecPHRZr38WBtOuv5Qava3opKML32Vi3N8UN2KQRBU75Hcjc0IVMg5BgGId96tNRKHggVKM5HRFM6vqJ7Kw2SX2pV5hZ/RgG/e6nQIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFAn/+cLg7oxDH0ASzCr3CRJ6beLVMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEAAwcjnelyBZLvh0Yxef8Uquy/UDRr3ygbfrfkcMET34QDPNzFwAhUk9roZYva2a6r8yeQ0euAFi2yYbmSA98A+d1r7HCe+gWp6Qj2jM1tnK+FayrpkAlH1k2Gfr9gSlRGWIlewTVduGu7jQPI9aBMEEIGIZCA2zsdmxWcLb6f0lZSwwAPZ7xYGNv552btMw9LkXoX2RSQ1lFAE0Zv3IGqGOdaNJspoKUZebZTbJ6Ims7f8z/pyC7H9+ZeqcELy9vdGpo1nxgfSFhASIAIqb4VSfbXf/CpmxvHKqUXE5wVUXURicSWtVYhDsOmEvsCVy0Rv53a5TMJZ2pAacEl46bC4zGCAQcwggEDAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JRMAkGBSsOAwIaBQAwDQYJKoZIhvcNAQEBBQAEgYCE7QOZDuP1Wjc9zbVwAWlzVyC2+9wtaIwPxLdQtXo9SB2kKBdw4X3IoF4avJvEKyQ8u2s0gE3cLx89RgmhDkLYSV9CjXG/K6R3uKQhozQNnBnm6iROMeEx+/nP328nRRaAMpvbiHLedw/XGCzi61RuBAZcGy/TzTNTpgtdTGmQ9g==
         */

        /**
         * 1：解析交易发起方的区块链地址
         * sdk支持key的base64签名计算出CFCA证书所在的区块链地址和对应的公钥私钥对和其所在的区块链地址：
         * 创建企业主体发起账户：企业的第一个ukey
         */
        String adminCFCACertBase64SignStr = "MIIFOgYJKoZIhvcNAQcCoIIFKzCCBScCAQExCzAJBgUrDgMCGgUAMCEGCSqGSIb3DQEHAaAUBBI5MTMyMDUwODM0NjM4NjM4NU6gggPlMIID4TCCAsmgAwIBAgIFEBCXclEwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDUyMDU5WhcNMTkxMDIzMDUyMDU5WjCBmDELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFLMEkGA1UEAwxCMDQxQE45MTM0MDg4MTY3NDIzMDA4MFVA5a6J5b695pe65p2l5peg57q65biD5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjz3skGnkEQljL4/yAhpiiRO1pKOiwx0sbm8WrRRmmUiTsXsrtJMWP782nWNv27EVPS7rLOgecPHRZr38WBtOuv5Qava3opKML32Vi3N8UN2KQRBU75Hcjc0IVMg5BgGId96tNRKHggVKM5HRFM6vqJ7Kw2SX2pV5hZ/RgG/e6nQIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFAn/+cLg7oxDH0ASzCr3CRJ6beLVMB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEAAwcjnelyBZLvh0Yxef8Uquy/UDRr3ygbfrfkcMET34QDPNzFwAhUk9roZYva2a6r8yeQ0euAFi2yYbmSA98A+d1r7HCe+gWp6Qj2jM1tnK+FayrpkAlH1k2Gfr9gSlRGWIlewTVduGu7jQPI9aBMEEIGIZCA2zsdmxWcLb6f0lZSwwAPZ7xYGNv552btMw9LkXoX2RSQ1lFAE0Zv3IGqGOdaNJspoKUZebZTbJ6Ims7f8z/pyC7H9+ZeqcELy9vdGpo1nxgfSFhASIAIqb4VSfbXf/CpmxvHKqUXE5wVUXURicSWtVYhDsOmEvsCVy0Rv53a5TMJZ2pAacEl46bC4zGCAQcwggEDAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JRMAkGBSsOAwIaBQAwDQYJKoZIhvcNAQEBBQAEgYCE7QOZDuP1Wjc9zbVwAWlzVyC2+9wtaIwPxLdQtXo9SB2kKBdw4X3IoF4avJvEKyQ8u2s0gE3cLx89RgmhDkLYSV9CjXG/K6R3uKQhozQNnBnm6iROMeEx+/nP328nRRaAMpvbiHLedw/XGCzi61RuBAZcGy/TzTNTpgtdTGmQ9g==";
        BlockchainKeyPair adminCFCACertKeyPair = SecureKeyGenerator.generateCfcaAddress(adminCFCACertBase64SignStr);
        //证书私钥：不返回。
        String adminCFCACertKeyPairPriKey = adminCFCACertKeyPair.getPriKey();
        //证书公钥：
        String adminCFCACertKeyPairPubKey = adminCFCACertKeyPair.getPubKey();
        //证书的区块链地址：
        String adminCFCACertKeyPairBubiAddress = adminCFCACertKeyPair.getBubiAddress();
        System.out.println("证书的公钥是：" + adminCFCACertKeyPairPubKey);
        System.out.println("证书的地址是：" + adminCFCACertKeyPairBubiAddress);
    }


    /**
     * 交易发起人创建企业主体、payment账户、子账户
     */
    @Test
    public void createData() {
        //组装返回值
        /*
        BlockchainAccount entityAccount = new BlockchainAccount();
        entityAccount.setAddress(entity.getBubiAddress());
        entityAccount.setPublicKey(entity.getPubKey());
        entityAccount.setPrivateKey(entity.getPriKey());
        */

        BlockchainKeyPair subAccount = SecureKeyGenerator.generateBubiKeyPair();
        BlockchainKeyPair newCompany = SecureKeyGenerator.generateBubiKeyPair();
        BlockchainKeyPair payment = SecureKeyGenerator.generateBubiKeyPair();


        //交易发起人区块链账户
        String sponsorAddr = "a001b283997ff78f6ad2ff857efd1183af4a7cbcb73b09";
        String sponsorPub = "b0015363ce09c777f4322c52bcecc4e3050ec2a3da80f30335ce3467339e5604b46515";
        String sponsorPriv = "c00181aab142365deefa41954969d0a516a0e622b5f3fc38d1af621b766d1bf12386d1";
        String newCompanyBubiAddress = newCompany.getBubiAddress();
        System.out.println("交易发起人区块链地址：" + sponsorAddr);
        System.out.println("交易发起人公钥：" + sponsorPub);
        System.out.println("交易发起人区块链地址：" + sponsorPriv);
        System.out.println("=============");

        //1：发起人创建新企业主体区块链账号
        try {
            CreateAccountOperation createAccountOperation = new CreateAccountOperation.Builder()
                    .buildDestAddress(newCompanyBubiAddress)
                    // 权限部分
                    .buildPriMasterWeight(100)
                    .buildPriTxThreshold(100)
                    .build();
            operationService.newTransaction(sponsorAddr)
                    .buildAddOperation(createAccountOperation)
                    .buildAddSigner(sponsorPub, sponsorPriv)
                    .commit();
            System.out.println("发起人企业主体创建---start");
            System.out.println("企业主体创建区块链地址：" + newCompany.getBubiAddress());
            System.out.println("企业主体公钥：" + newCompany.getPubKey());
            System.out.println("企业主体私钥：" + newCompany.getPriKey());
            System.out.println("发起人企业主体创建成功---end");
        } catch (SdkException e) {
        }


        //2：发起人创建创建payment账户
        try {
            System.out.println("payment：address-" + payment.getBubiAddress() + ", priv-" + payment.getPriKey() + "，pub-" + payment.getPubKey());
            CreateAccountOperation createAccountOperation1 = new CreateAccountOperation.Builder()
                    .buildDestAddress(payment.getBubiAddress())
                    // 权限部分
                    .buildPriMasterWeight(10500)
                    .buildPriTxThreshold(50)
                    .build();
            operationService.newTransaction(sponsorAddr)
                    .buildAddOperation(createAccountOperation1)
                    .buildAddSigner(sponsorPub, sponsorPriv)
                    .commit();
            System.out.println("发起人创建payment账户---start");
            System.out.println("payment账户区块链地址：" + payment.getBubiAddress());
            System.out.println("payment账户公钥：" + payment.getPubKey());
            System.out.println("payment账户私钥：" + payment.getPriKey());
            System.out.println("发起人创建payment账户---end");
        } catch (SdkException e) {
        }

        //3：发起人创建子账号，并设置操作子账号的相关权限。
        try {
            System.out.println("subAccount：address-" + subAccount.getBubiAddress() + ", priv-" + subAccount.getPriKey() + "，pub-" + subAccount.getPubKey());
            CreateAccountOperation createAccountOperation2 = new CreateAccountOperation.Builder()
                    .buildDestAddress(subAccount.getBubiAddress())
                    .buildPriTxThreshold(50)
                    /**
                     * 1 CREATE_ACCOUNT 创建账号
                     * 2 ISSUE_ASSET 发行资产
                     * 3 PAYMENT 转移资产
                     * 4 SET_METADATA 设置metadata
                     * 5 SET_SIGNER_WEIGHT 设置权重
                     * 6 SET_THRESHOLD 设置门限
                     */
                    .buildAddPriTypeThreshold(OperationTypeV3.PAYMENT, 100)
                    .buildAddPriTypeThreshold(OperationTypeV3.SET_SIGNER_WEIGHT, 10000)
                    .buildAddPriTypeThreshold(OperationTypeV3.SET_THRESHOLD, 10000)
                    .buildAddPriSigner(newCompanyBubiAddress, 10500)
                    .buildAddPriSigner(payment.getBubiAddress(), 100)
                    .build();
            operationService.newTransaction(sponsorAddr)
                    .buildAddOperation(createAccountOperation2)
                    .buildAddSigner(sponsorPub, sponsorPriv)
                    .commit();
            System.out.println("发起人创建subAccount账户---start");
            System.out.println("subAccount账户区块链地址：" + subAccount.getBubiAddress());
            System.out.println("subAccount账户公钥：" + subAccount.getPubKey());
            System.out.println("subAccount账户私钥：" + subAccount.getPriKey());
            System.out.println("发起人创建subAccount账户---end");
        } catch (SdkException e) {
        }
    }


    /**
     * 修改账户的matadata
     */
    @Test
    public void modifyMetadata() {
        //交易发起人区块链账户
        String sponsorAddr = "a0019b80ca7dd08c14f053d90a9d1a949499e9da9f92d9";
        String sponsorPub = "b001c98089778e90e4e7ddc685d4ed18a39f84629edf6214a34f173523f3ca22af6703";
        String sponsorPriv = "c001b11bdfd7576e42dcfa45d95af0b47786add91db113487171b59399805f59615d83";

        //交易发起人在目标账户签名列表中
        String targetAddr = "a0012fc44b28844f605014ee7de8bc8691911c163bb5e2";
        String targetPub = "b0016a881d0b5ec7dfa787c9ce843069cdc79660bd6621e98bb8adf22deda8c2178bb3";
        String targetPriv = "c0014a6bda6e1495de2d55e603b194db3b11db42a2464d62de6f101f51f72a936aef94";

        //1:自己修改自己：
//        addMetadata(operationService, targetAddr, targetAddr, targetPub, targetPriv);


        //2:修改目标的账户，需要发起人在目标签名列表中：
        addMetadata(operationService, targetAddr, sponsorAddr, sponsorPub, sponsorPriv);

    }

    /**
     * @param operationService 操作服务的服务
     * @param targetAddr       被操作的目标地址：目标地址
     * @param sponsorAddr      交易发起人地址
     * @param sponsorPub       交易发起人公钥
     * @param sponsorPriv      交易发起人私钥
     */
    private void addMetadata(BcOperationService operationService, String targetAddr, String sponsorAddr, String sponsorPub, String sponsorPriv) {
        //组装操作
        //如果matadata的key相同，则matadata的版本+1
        try {
            SetMetadataOperation operation = new SetMetadataOperation.Builder().buildMetadata("key-x2", "key-value2222").build();
            operation.setOperationSourceAddress(targetAddr);        //组装交易
            TransactionCommittedResult result = operationService
                    .newTransaction(sponsorAddr)
                    .buildAddOperation(operation)
                    .commit(sponsorPub, sponsorPriv);
            System.out.println("success!  hash: " + result.getHash());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取交易历史
     */
    @Test
    public void getTransactionHistory() {
        //TransactionHistory transactionHistoryByAddress = rpcService.getTransactionHistoryByAddress("");
        TransactionHistory result = rpcService.getTransactionHistoryBySeq(316027L, 0, 100);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    //voucher_blob 表中通过签名获取证书公钥和证书区块链地址
    // sing为签名的base64的十六进制
    public void paserCert() throws Exception {
        String sing = "4d4949467877594a4b6f5a496876634e415163436f494946754443434262514341514578447a414e42676c67686b67425a514d45416745464144414c42676b71686b694739773042427747676767502f4d4949442b7a434341754f67417749424167494645434178494a63774451594a4b6f5a496876634e41514546425141775744454c4d416b474131554542684d43513034784d44417542674e5642416f544a304e6f6157356849455a70626d467559326c68624342445a584a3061575a7059324630615739754945463164476876636d6c30655445584d4255474131554541784d4f51305a445153425552564e5549453944515445774868634e4d5467774d5441794d446b794e6a517a5768634e4d6a41774d5441794d446b794e6a517a576a43426c7a454c4d416b474131554542684d4351303478467a415642674e5642416f54446b4e47513045675645565456434250513045784d524577447759445651514c4577684356554a4a564556545644455a4d4263474131554543784d5154334a6e59573570656d463061573975595777744d5446424d44384741315545417777344d445578514f696c762b69586a2b57666e2b652b6a75575668756930754f616369656d5a6b4f5746724f57507545424f4f5445314e4441784f54464e51545a554d6c52424f444e4e51444577676745694d4130474353714753496233445145424151554141344942447741776767454b416f4942415144715176572f4f444447754a316237707347726f4551536458426e4b6c795650635056496c3572656f593665635246454966756a2f49447a796372436837523073736c33584e6c3443776c327557764f6f5042597a794d41366a536b6b2f744a62736f5766793051664e68436a5970472f3647324f57424d346d306d592f30705151656648774b716b547573344949376c566e6f4359653850575a6d704f566a6d4b3376342b43544f54667256556d6762493430673556336c4f396478422b62536f4e39672b70332f7833733842736b4377336a6d35334b68446c7979715372675837674f63376c6442705268756b43485179392b347650495968694c2b4f7268465554726f6d7930636233562f6e524c74336b4f5a772f7a48763530635466504c6756644b725367546437766b7576574a72586e7131416c3957762f664d4f44556e36484a32416b5957677746584f7534372b495a41674d424141476a6759737767596777487759445652306a42426777466f41557a3343645965756466433634393873435150634a6e66347a644941774f51594456523066424449774d4441756f4379674b6f596f6148523063446f764c33566a636d777559325a6a5953356a6232307559323476556c4e424c324e79624451774d7a63354c6d4e796244414c42674e564851384542414d4342734177485159445652304f4242594546416f766c4468326b2b375a31557a534a336842554554474e4753494d413047435371475349623344514542425155414134494241514378302b55395a38317a53417a6946586451353153774d5a7951382f55523365384e546d2b726631566c6746642b2b634556367361686b5537366f6d305471375a3963493051427935614f6b637166367a666e486d7a4748654c344530566a426d38326d517a744e566b416f3155725750776e4c7259696954324657706156734f484956744d5750746e45305467456e2f4f314e515743586f524c422b684a58576a32776d37684c6d39466436663776306953515754437254794b5a70325257386451576248482b4636557364484a747a2f4a513669746d7930634e4d324f42507358475a656e7150337237554b66316564564b344c4f4f5341792f6a6b324b3375616135384250674e777547715134706e6a577263744e32567330466b67365365616a634f6265772f354f52585249624a506e714b6c3650556b4a4a6e4b34386a2b4a794f7537706143594378496c782f6e647a574d5949426a4443434159674341514577595442594d517377435159445651514745774a44546a45774d4334474131554543684d6e51326870626d4567526d6c755957356a6157467349454e6c636e52705a6d6c6a59585270623234675158563061473979615852354d526377465159445651514445773544526b4e42494652465531516754304e424d51494645434178494a63774451594a59495a494157554442414942425141774451594a4b6f5a496876634e4151454c425141456767454164334d2b614c4139586b732b5773554265317a6f764364774c4735636b344366354c6c4c32695552434f6f2b6e2f2b3879706b696453434a6a6d5254503051784f3536584c4b373230362b4e6d6173782f494149312b30542b4b314b326957617a794c6c646732377270784c6479486a423456656e64366c4b6465532b6b704d65386d3535337a70535642592f46713173584f426b71633565506d785970574a4c6f5a454444354f6d6474655a7846763032382f317a664e696a6a4967664878653669793968775a72395352542b37435675536c3937596d4735414f7879584175544b7246716c6f314d4b2b635970734579644667456e6d4b62674a497a484c334a306272303352636d766a65387a4348346d567a52366b2b6b3064664a75735556556c643575646c592f6442686f4f6d477459774b6171534f6569762b6232565a31722f6e4c5157445271487532554f36554848773d3d";
        String base64CfcaDigest = new String(Hex.decodeHex(sing));
        BlockchainKeyPair blockchainKeyPair = SecureKeyGenerator.generateCfcaAddress(base64CfcaDigest);
        System.out.println(blockchainKeyPair.getBubiAddress());

    }

}
