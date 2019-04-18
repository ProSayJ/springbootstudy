package adapter.blockchain.blockchain.service;

import cn.bubi.access.adaptation.blockchain.bc.OperationTypeV3;
import cn.bubi.access.adaptation.blockchain.bc.RpcService;
import cn.bubi.access.adaptation.blockchain.bc.response.TransactionHistory;
import cn.bubi.access.starter.BCAutoConfiguration;
import cn.bubi.access.starter.BCAutoConfigurationSpi;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import cn.bubi.sdk.core.exception.SdkException;
import cn.bubi.sdk.core.operation.impl.CreateAccountOperation;
import cn.bubi.sdk.core.operation.impl.SetMetadataOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.transaction.model.TransactionCommittedResult;
import com.prosayj.springboot.adapter.blockchain.model.BlockchainAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * @author wangjingru
 * @description 区块链数据模拟
 * @email wangjingru@bubi.cn
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

    //企业实名第一步：创建企业主体的区块链地址和公钥私钥和地址：
    @Test
    public void createCompany() {
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

        /**
         * 2：生成企业主体三元素
         */
        //新创建企业主体三元素：公钥、私钥、区块链地址
        BlockchainKeyPair newCompany = SecureKeyGenerator.generateBubiKeyPair();
        String newCompanyBubiAddress = newCompany.getBubiAddress();
        String newCompanyPriKey = newCompany.getPriKey();
        String newCompanyPubKey = newCompany.getPubKey();

        /**
         * 3：发起人发起交易
         * 创建企业的区块链地址，并将admin证书的区块链地址添加至
         */
        try {
            // 3.1创建交易内的操作：可以是多个。
            CreateAccountOperation.Builder createAccountOperationBuild = new CreateAccountOperation.Builder()
                    .buildDestAddress(newCompanyBubiAddress)
                    // 权限部分
                    .buildPriMasterWeight(100)
                    .buildPriTxThreshold(100);
            //如果证书地址为null，则不添加
            createAccountOperationBuild.buildAddPriSigner(adminCFCACertKeyPairBubiAddress, 100);
            CreateAccountOperation createAccountOperation = createAccountOperationBuild.build();

            //3.2：提交交易,提交交易可以有两种方式:
            /**
             3.2.2：交易发起人通过帐户池来对发起交易，由账户池内的账户来对交易进行签名打包分发到区块链底层。
             eg：a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
             查看账户：http://192.168.6.46:19333/getAccount?address=a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
             查看该账户的交易：http://192.168.6.46:19333/getTransactionHistory?hash=a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
             */
            operationService.newTransactionByAccountPool()
                    .buildAddOperation(createAccountOperation)
                    .commit();

            /**
             3.2.1：交易发起人自己对交易进行签名后发起交易。交易发起人区块链账户
             */
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
        BlockchainKeyPair payment = SecureKeyGenerator.generateBubiKeyPair();


        //交易发起人区块链账户
        String sponsorAddr = "a001b283997ff78f6ad2ff857efd1183af4a7cbcb73b09";
        String sponsorPub = "b0015363ce09c777f4322c52bcecc4e3050ec2a3da80f30335ce3467339e5604b46515";
        String sponsorPriv = "c00181aab142365deefa41954969d0a516a0e622b5f3fc38d1af621b766d1bf12386d1";
        String newCompanyBubiAddress = "";
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
            System.out.println("企业主体创建成功");
        } catch (SdkException e) {
        }


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
            System.out.println("payment创建成功");
        } catch (SdkException e) {
        }

        try {
            System.out.println("subAccount：address-" + subAccount.getBubiAddress() + ", priv-" + subAccount.getPriKey() + "，pub-" + subAccount.getPubKey());
            CreateAccountOperation createAccountOperation2 = new CreateAccountOperation.Builder()
                    .buildDestAddress(subAccount.getBubiAddress())
                    .buildPriTxThreshold(50)
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
            System.out.println("subAccount创建成功");
        } catch (SdkException e) {
        }
    }

    @Test
    public void generateCfcaAddress() {
        String base64SignStr = "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";
        BlockchainKeyPair blockchainKeyPair = SecureKeyGenerator.generateCfcaAddress(base64SignStr);
        BlockchainAccount blockchainAccount = new BlockchainAccount();
        blockchainAccount.setAddress(blockchainKeyPair.getBubiAddress());
        blockchainAccount.setPublicKey(blockchainKeyPair.getPubKey());
        System.out.println(blockchainAccount.toString());
        System.out.println("address : " + blockchainAccount.getAddress());
    }

    /**
     * 解析某证书签名串内的地址
     */
    @Test
    public void test() {
        String sign = "MIIFswYJKoZIhvcNAQcCoIIFpDCCBaACAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPsMIID6DCCAtCgAwIBAgIFIDIAFykwDQYJKoZIhvcNAQEFBQAwVzELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEWMBQGA1UEAxMNQ0ZDQSBDUyBPQ0ExMTAeFw0xODA2MDcwNjI0MTNaFw0yMzA2MDcwNjI0MTNaMHAxCzAJBgNVBAYTAkNOMRswGQYDVQQKExJDRkNBIE9wZXJhdGlvbiBDQTIxDjAMBgNVBAsTBVlVWkhJMRkwFwYDVQQLExBPcmdhbml6YXRpb25hbC0zMRkwFwYDVQQDExBCQU5LR1k4MDAwMTA5NjYyMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjMpx1c8Z2bzVpYT9z8+ei9u6sIzHZvi8FBc/Ej2xpiDrl2USCjQG1qlkWnRMiVzGG2Z+GJGfGitPND4IHc+tpet7Oo8ljxzXQ1P1Z3Q/Z9zWAmm/HSgRTi/EL9qu8OWvuh8Ku/AUoUMJoFkfaYFpjhqPUYdokwPTAWSrQX5P5Df8fuw9hZ3gCO5u8GEgU6BzhQBwwuqfYT8wtK1xNGN2YtkBuzDh1tk8uPBs8Bg1eXIHt140GmdrNq3beRTL4pYBV0M3bMuV14wiH/bAt/N8lpurzp3SINw98R2wqRqMmvlwk28xy//rs417t9cezitF92t3QgQSdysvxIdxT/ZlwwIDAQABo4GhMIGeMB8GA1UdIwQYMBaAFBQPeH9jJURsok4MM3WwHRFJz/tFMAwGA1UdEwEB/wQCMAAwPgYDVR0fBDcwNTAzoDGgL4YtaHR0cDovL2NybC5jZmNhLmNvbS5jbi9vY2ExMS9SU0EvY3JsMzUxMTIuY3JsMA4GA1UdDwEB/wQEAwIE8DAdBgNVHQ4EFgQUL53Yfym1QrtXSCoP+WBEz29EbvAwDQYJKoZIhvcNAQEFBQADggEBAI+sYA0c0NsMkbMtOOE4pjC7Qi4hqdBSl7tkcmaB60jwFXoF8GbHoRlZojlMqdNm30GDF10a5Jw3eSSYSzEAUlQKJ2jlBMPbFDxvFQ6LOU9WvG7kH45uWRJ5JA+eEgk5Yw+SHMEEnJlnHuOjJ1bicLONZIrFBtcziQR8H68ELzouvP0jZcHU8CAOfPbav37WVSt7ux+VexCLsdCyRV570rmyYWRMio/c5eGaJIT9SXSwwJId7BYerkSdFseLFLysF+tOk2scPk8eYtM43Q+FQnQIjz54daZ7JlFDoAh9hdMHNDyTsM44WIA2N+GjysXeiy7nbT2lRklBHApfVmJ16D0xggGLMIIBhwIBATBgMFcxCzAJBgNVBAYTAkNOMTAwLgYDVQQKEydDaGluYSBGaW5hbmNpYWwgQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkxFjAUBgNVBAMTDUNGQ0EgQ1MgT0NBMTECBSAyABcpMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIIBAGFZFkmADHSNB5HoMNRokoKriudu2+aMDcGNU0xBaGDZsYe6lqEEox3Gmr+0my/cZPPyHWI18OUu2WKqS4iVSTfFdJoDPGzNUNNBy7gmFKDaz4MKUdn7QBrx0W4Wh80Arrfn7qWXUN+HD6bKMRmy+TM8ALg3x302/7E8dINd4TZmUNx0wMdLtXBlGgVVRD76/ySToeP5jlmzJMio4kyq0DqzTFoxXpAxp46f0dGUCj4snQnzI4DIS+WUWnW5UweK+LuPJ3rWl4SPtF7Ahk0bLapD706rXWs3N4lc1pCma01wpCSP6HIIAfmBQblzpLzacJuswNRogFt/a6BIPgqTLw4=";
        BlockchainKeyPair blockchainKeyPair = SecureKeyGenerator.generateCfcaAddress(sign);
        if (blockchainKeyPair != null) {
            System.out.println("地址：" + blockchainKeyPair.getBubiAddress());
        }
    }

    @Test
    public void modifyMetadata() {
        //交易发起人区块链账户
        String sponsorAddr = "a0019b80ca7dd08c14f053d90a9d1a949499e9da9f92d9";
        String sponsorPub = "b001c98089778e90e4e7ddc685d4ed18a39f84629edf6214a34f173523f3ca22af6703";
        String sponsorPriv = "c001b11bdfd7576e42dcfa45d95af0b47786add91db113487171b59399805f59615d83";

        //交易发起人在目标账户签名列表中
        String targetAddr = "a0018abfb498be8be28f4be6ef1521f9813228db53a30b";
        String targetPub = "b001c9fab71a0196f99a82225a8cda117f00be8d77b6156f832eb332f475b7db4e04f1";
        String targetPriv = "c001f4f8b271f96f65617e8e0cb09ec4452d3b75f865ffa162f4d3fdc1b0f6702975e0";


        //组装操作
        try {
            SetMetadataOperation operation = new SetMetadataOperation.Builder().buildMetadata("key-x", "key-value").build();
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

    @Test
    public void getTransactionHistory() {
        TransactionHistory result = rpcService.getTransactionHistoryBySeq(316027L, 0, 100);
        System.out.println(result.toString());
    }

}
