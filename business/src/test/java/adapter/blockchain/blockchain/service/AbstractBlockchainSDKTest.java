package adapter.blockchain.blockchain.service;

import cn.bubi.access.adaptation.blockchain.bc.OperationTypeV3;
import cn.bubi.access.adaptation.blockchain.bc.RpcService;
import cn.bubi.access.adaptation.blockchain.bc.response.TransactionHistory;
import cn.bubi.access.starter.BCAutoConfiguration;
import cn.bubi.access.starter.BCAutoConfigurationSpi;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import cn.bubi.sdk.core.exception.SdkException;
import cn.bubi.sdk.core.operation.OperationFactory;
import cn.bubi.sdk.core.operation.impl.CreateAccountOperation;
import cn.bubi.sdk.core.operation.impl.SetMetadataOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.transaction.Transaction;
import cn.bubi.sdk.core.transaction.TransactionContent;
import cn.bubi.sdk.core.transaction.model.TransactionBlob;
import cn.bubi.sdk.core.transaction.model.TransactionCommittedResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.prosayj.springboot.adapter.blockchain.model.BlockchainAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @description 区块链数据模拟
 * @creatTime 2018/4/24 18:37
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BCAutoConfiguration.class, BCAutoConfigurationSpi.class})
public class AbstractBlockchainSDKTest {
    @Autowired
    private BcOperationService operationService;
    @Autowired
    private RpcService rpcService;

    /**
     * 创建一个目标账户(企业主体)
     * 查看账户：http://192.168.6.46:19333/getAccount?address=a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
     * 查看该账户的交易：http://192.168.6.46:19333/getTransactionHistory?hash=a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
     */
    @Test
    public void createCompanyByUserCert() {
        /**
         * 生成企业主体三元素
         */
        //新创建企业主体三元素：公钥、私钥、区块链地址
        BlockchainKeyPair newCompany = SecureKeyGenerator.generateBubiKeyPair();
        String newCompanyBubiAddress = newCompany.getBubiAddress();
        String newCompanyPriKey = newCompany.getPriKey();
        String newCompanyPubKey = newCompany.getPubKey();

        /**
         * 发起人发起交易
         * 创建企业的区块链地址，并将admin证书的区块链地址添加至
         */
        try {
            // 1：创建交易内的操作：可以是多个。
            CreateAccountOperation.Builder createAccountOperationBuild = new CreateAccountOperation.Builder()
                    .buildDestAddress(newCompanyBubiAddress)
                    // 设置自己的基础权限
                    .buildPriMasterWeight(100)
                    //设置权限基础门限值
                    .buildPriTxThreshold(100);
            CreateAccountOperation createAccountOperation = createAccountOperationBuild.build();

            //2：交易发起人自己对交易进行签名后发起交易。交易发起人区块链账户
            //eg：a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
            String sponsorAddr = "a001b283997ff78f6ad2ff857efd1183af4a7cbcb73b09";
            String sponsorPub = "b0015363ce09c777f4322c52bcecc4e3050ec2a3da80f30335ce3467339e5604b46515";
            String sponsorPriv = "c00181aab142365deefa41954969d0a516a0e622b5f3fc38d1af621b766d1bf12386d1";
            operationService.newTransaction(sponsorAddr)
                    .buildAddOperation(createAccountOperation)
                    .buildAddSigner(sponsorPub, sponsorPriv)
                    .commit();
            System.out.println("新的企业主体信息是：" + newCompany);
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

    /**
     * 为目标账户的签名列表添加一个地址，并设置权重
     */
    @Test
    public void addSignerAndSetWeight() {
        String targetAddress = "a00180eba77b3ce25c68655840dff72d3d88bd6042ecd4";
        String signerAddress = "123";
        Integer weight = 55;
        try {
            //新建一个交易
            Transaction transaction = operationService
                    .newTransaction(targetAddress)
                    .buildAddOperation(OperationFactory.newSetSignerWeightOperation(signerAddress, weight));

            //获取交易
            TransactionBlob transactionBlob = transaction
                    //默认每一个交易等待的区块链偏移量：1个区块偏移量=3秒或1分钟，可以用3s进行推断，最快情况1分钟=20个区块偏移量
                    .buildFinalNotifySeqOffset(100)
                    .generateBlob();

            //暂存transaction，签名后提交
            TransactionContent.put(transactionBlob.getHash(), transaction);
            System.out.println("发起交易之前获取获取交易的hash 和 blob：" + transactionBlob.getHash());


            //前端拿到hash提交
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


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
     * 通过账户池提交交易
     */
    @Test
    public void createCompanyByAccountPool() {
        //新创建企业主体三元素：公钥、私钥、区块链地址
        BlockchainKeyPair newCompany = SecureKeyGenerator.generateBubiKeyPair();
        String newCompanyBubiAddress = newCompany.getBubiAddress();
        String newCompanyPriKey = newCompany.getPriKey();
        String newCompanyPubKey = newCompany.getPubKey();

        /**
         * 组装交易体(没有发起人)
         */
        try {
            // 创建交易内的操作：可以是多个。
            CreateAccountOperation.Builder createAccountOperationBuild = new CreateAccountOperation.Builder()
                    .buildDestAddress(newCompanyBubiAddress)
                    // 权限部分
                    .buildPriMasterWeight(100)
                    .buildPriTxThreshold(100);
            CreateAccountOperation createAccountOperation = createAccountOperationBuild.build();


            /**
             提交交易，使用账户池：
             交易发起人通过帐户池来对发起交易，由账户池内的账户来对交易进行签名打包分发到区块链底层。
             通过账户池发起交易无需使用方对发起人签名，提交时账户池会自动为此笔交易签名
             */
            operationService.newTransactionByAccountPool()
                    .buildAddOperation(createAccountOperation)
                    .commit();
            System.out.println("新的企业主体信息是：" + newCompany);
        } catch (SdkException e) {
            e.printStackTrace();
        }
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

}
