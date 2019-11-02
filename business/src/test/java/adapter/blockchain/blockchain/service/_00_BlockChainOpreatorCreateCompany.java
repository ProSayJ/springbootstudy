package adapter.blockchain.blockchain.service;

import adapter.blockchain.blockchain.AdapterBlockSDKUtil;
import cn.bubi.access.starter.BCAutoConfiguration;
import cn.bubi.access.starter.BCAutoConfigurationSpi;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import cn.bubi.sdk.core.exception.SdkException;
import cn.bubi.sdk.core.operation.impl.CreateAccountOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangjian
 * @description 底层SDK_测试_创建企业主体
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/24 15:40
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {SDKConfig.class, SDKProperties.class})
@SpringBootTest(classes = {BCAutoConfiguration.class, BCAutoConfigurationSpi.class})
public class _00_BlockChainOpreatorCreateCompany {
    @Autowired
    private BcOperationService operationService;

    @Test
    public void paserCertSignStr() {
        String certSignStr = "MIIFMgYJKoZIhvcNAQcCoIIFIzCCBR8CAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPrMIID5zCCAs+gAwIBAgIFEBCXckcwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDQ0OTM5WhcNMTkxMDIzMDQ0OTM5WjCBnjELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFRME8GA1UEAwxIMDQxQE45MTMyMDUwODM0NjM4NjM4NU5A6IuP5bee57yY5p2l5peg55WM5bel6Im65ZOB5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDANjmPzuBUf3bCeX090K3Y4SsSPbeklcQ3/LXSfBcVEuW8Y7nFgVLyfhONG8diimPtCOGzeieUeQflbSk9gvDuf1b0EbT7PR+vVe6sV8Vvq9gueRtmZ+9QsUdxcblSWb9wMPg2/zDRR9ytMSQ6hpzYVgWxm0I14hJr4t0+7TGj/QIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFFXco56p6W16FMVwjI5H9K4HWgE4MB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEANpenbl5r3LvS7ZRafmGxw2ArrFmZvSR20ALUZh8JETcD7vRUlBX+pcgtUg+zMl2E6Ir1WWsvm2n7mJd38WEwnRudWs6G8fj8xULNS32uAnUQrdwqRQDkv43Y3591vqHkNUfCT1Z/x7L0IV8M9XRkBHVPZYhShp8Ebm/KdnQF+m6KBJhGJkPZw8INcCdfaiJDNGNguboTnpO0/Q8TFuhbRDLMeH9LR+zTYmHd1VI+XGAfi7mvSGCNXuNVTl40HrA0DsYDs5eJtLIaj/obVItx/vih6aNQ3K43Wt/lRD8iBQfk8ZEtuEjcLUjJrR+q0x+NpjRSJZ8/h7riCuv5RklCZDGCAQswggEHAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JHMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIGATJJdryIW6ML6cGU2GxNRODiVTMB5g5pI6QgDmigtaSWETE0XACqqwBBKuF1Ich2OIdq4bGmCtZ0oGp+8BeXC14+HiGGl6wJedlsiC8ggSSyCziqNzmiBPAqVFEG4cL1JYpiAhyCngbR3Z7w9Nd78A6PGxUeAaEMAqGnsIEUd56g=";
        BlockchainKeyPair blockchainKeyPair = AdapterBlockSDKUtil.paseCertSignStr(certSignStr);
        System.out.println("blockchainKeyPair.getBubiAddress() = " + blockchainKeyPair.getBubiAddress());
        System.out.println("blockchainKeyPair.getPubKey() = " + blockchainKeyPair.getPubKey());
        System.out.println("blockchainKeyPair.getPriKey() = " + blockchainKeyPair.getPriKey());
    }

    /**
     * 创建一个目标账户(企业主体)
     * 查看账户：http://192.168.6.46:19333/getAccount?address=a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
     * 查看该账户的交易：http://192.168.6.46:19333/getTransactionHistory?hash=a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
     */
    @Test
    public void createCompanyByUserCert() {
        /**
         创建企业主体区块链账户的发起方是：企业绑定的第一个证书发起：前端通过证书里面的私钥加密社会统一信用证代码
         签名过程：社会统一信用证代码-->base64--->前端控件签名
         base64在线加密：http://tool.oschina.net/encrypt?type=3
         后端可以解析这个加密串获取证书的区块链地址和公钥

         eg：
         企业：苏州缘来无界工艺品有限公司
         社会统一信用证代码：91320508346386385N
         base64: OTEzMjA1MDgzNDYzODYzODVO
         前端控件加密：C:\java_soft\v3.4.0.1\程序\Demo\MsgSign.html
         选项：PKCS#7不带原文签名   SHA-256
         加密后结果：
         "MIIFMgYJKoZIhvcNAQcCoIIFIzCCBR8CAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPrMIID5zCCAs+gAwIBAgIFEBCXckcwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDQ0OTM5WhcNMTkxMDIzMDQ0OTM5WjCBnjELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFRME8GA1UEAwxIMDQxQE45MTMyMDUwODM0NjM4NjM4NU5A6IuP5bee57yY5p2l5peg55WM5bel6Im65ZOB5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDANjmPzuBUf3bCeX090K3Y4SsSPbeklcQ3/LXSfBcVEuW8Y7nFgVLyfhONG8diimPtCOGzeieUeQflbSk9gvDuf1b0EbT7PR+vVe6sV8Vvq9gueRtmZ+9QsUdxcblSWb9wMPg2/zDRR9ytMSQ6hpzYVgWxm0I14hJr4t0+7TGj/QIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFFXco56p6W16FMVwjI5H9K4HWgE4MB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEANpenbl5r3LvS7ZRafmGxw2ArrFmZvSR20ALUZh8JETcD7vRUlBX+pcgtUg+zMl2E6Ir1WWsvm2n7mJd38WEwnRudWs6G8fj8xULNS32uAnUQrdwqRQDkv43Y3591vqHkNUfCT1Z/x7L0IV8M9XRkBHVPZYhShp8Ebm/KdnQF+m6KBJhGJkPZw8INcCdfaiJDNGNguboTnpO0/Q8TFuhbRDLMeH9LR+zTYmHd1VI+XGAfi7mvSGCNXuNVTl40HrA0DsYDs5eJtLIaj/obVItx/vih6aNQ3K43Wt/lRD8iBQfk8ZEtuEjcLUjJrR+q0x+NpjRSJZ8/h7riCuv5RklCZDGCAQswggEHAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JHMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIGATJJdryIW6ML6cGU2GxNRODiVTMB5g5pI6QgDmigtaSWETE0XACqqwBBKuF1Ich2OIdq4bGmCtZ0oGp+8BeXC14+HiGGl6wJedlsiC8ggSSyCziqNzmiBPAqVFEG4cL1JYpiAhyCngbR3Z7w9Nd78A6PGxUeAaEMAqGnsIEUd56g="

         后端解密：
         证书的区块链地址：a004aafc0c43cc20dbd429f3f0ff3491e2effeff816419
         公钥: b0044d494944357a434341732b67417749424167494645424358636b63774451594a4b6f5a496876634e41514546425141775744454c4d416b474131554542684d43513034784d44417542674e5642416f544a304e6f6157356849455a70626d467559326c68624342445a584a3061575a7059324630615739754945463164476876636d6c30655445584d4255474131554541784d4f51305a445153425552564e5549453944515445774868634e4d5463784d44497a4d4451304f544d355768634e4d546b784d44497a4d4451304f544d35576a43426e6a454c4d416b474131554542684d4359323478467a415642674e5642416f54446b4e47513045675645565456434250513045784d513077437759445651514c4577524356554a4a4d525177456759445651514c45777446626e526c636e427961584e6c637a46524d45384741315545417778494d445178514534354d544d794d4455774f444d304e6a4d344e6a4d344e5535413649755035626565353779593570326c357065673535574d3562656c36496d36355a4f423570794a365a6d513559577335592b34514441774d4441774d4441784d4947664d413047435371475349623344514542415155414134474e4144434269514b42675144414e6a6d507a7542556633624365583039304b3359345373535062656b6c6351332f4c5853664263564575573859376e4667564c7966684f4e47386469696d5074434f477a656965556551666c62536b3967764475663162304562543750522b765665367356385676713967756552746d5a2b39517355647863626c53576239774d5067322f7a4452523979744d53513668707a59566757786d30493134684a723474302b3754476a2f514944415141426f3448304d4948784d42384741315564497751594d426141464d39776e5748726e5877757550664c416b4433435a332b4d3353414d45674741315564494152424d443877505159495949456368753871415145774d5441764267677242674546425163434152596a6148523063446f764c3364336479356a5a6d4e684c6d4e766253356a6269393163793931637930784e43356f644730774f51594456523066424449774d4441756f4379674b6f596f6148523063446f764c33566a636d777559325a6a5953356a6232307559323476556c4e424c324e79624449784f4441784c6d4e796244414c42674e564851384542414d43412b6777485159445652304f42425945464658636f35367036573136464d56776a493548394b3448576745344d423047413155644a5151574d425147434373474151554642774d434267677242674546425163444244414e42676b71686b6947397730424151554641414f43415145414e70656e626c3572334c7653375a5261666d47787732417272466d5a7653523230414c555a68384a45546344377652556c42582b7063677455672b7a4d6c324536497231575773766d326e376d4a6433385745776e5275645773364738666a3878554c4e53333275416e5551726477715251446b76343359333539317671486b4e55664354315a2f78374c304956384d3958526b424856505a59685368703845626d2f4b646e51462b6d364b424a68474a6b505a7738494e6343646661694a444e474e6775626f546e704f302f5138544675686252444c4d6548394c522b7a54596d48643156492b5847416669376d765347434e58754e56546c343048724130447359447335654a744c49616a2f6f62564974782f76696836614e51334b343357742f6c524438694251666b385a457475456a634c556a4a72522b7130782b4e706a52534a5a382f6837726943757635526b6c435a413d3dac
         */
        String certSignStr = "MIIFMgYJKoZIhvcNAQcCoIIFIzCCBR8CAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPrMIID5zCCAs+gAwIBAgIFEBCXckcwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDQ0OTM5WhcNMTkxMDIzMDQ0OTM5WjCBnjELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFRME8GA1UEAwxIMDQxQE45MTMyMDUwODM0NjM4NjM4NU5A6IuP5bee57yY5p2l5peg55WM5bel6Im65ZOB5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDANjmPzuBUf3bCeX090K3Y4SsSPbeklcQ3/LXSfBcVEuW8Y7nFgVLyfhONG8diimPtCOGzeieUeQflbSk9gvDuf1b0EbT7PR+vVe6sV8Vvq9gueRtmZ+9QsUdxcblSWb9wMPg2/zDRR9ytMSQ6hpzYVgWxm0I14hJr4t0+7TGj/QIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFFXco56p6W16FMVwjI5H9K4HWgE4MB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEANpenbl5r3LvS7ZRafmGxw2ArrFmZvSR20ALUZh8JETcD7vRUlBX+pcgtUg+zMl2E6Ir1WWsvm2n7mJd38WEwnRudWs6G8fj8xULNS32uAnUQrdwqRQDkv43Y3591vqHkNUfCT1Z/x7L0IV8M9XRkBHVPZYhShp8Ebm/KdnQF+m6KBJhGJkPZw8INcCdfaiJDNGNguboTnpO0/Q8TFuhbRDLMeH9LR+zTYmHd1VI+XGAfi7mvSGCNXuNVTl40HrA0DsYDs5eJtLIaj/obVItx/vih6aNQ3K43Wt/lRD8iBQfk8ZEtuEjcLUjJrR+q0x+NpjRSJZ8/h7riCuv5RklCZDGCAQswggEHAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JHMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIGATJJdryIW6ML6cGU2GxNRODiVTMB5g5pI6QgDmigtaSWETE0XACqqwBBKuF1Ich2OIdq4bGmCtZ0oGp+8BeXC14+HiGGl6wJedlsiC8ggSSyCziqNzmiBPAqVFEG4cL1JYpiAhyCngbR3Z7w9Nd78A6PGxUeAaEMAqGnsIEUd56g=";

        String adminCertBubiAddress = AdapterBlockSDKUtil.paseCertSignStr(certSignStr).getBubiAddress();

        //生成建企业主体三元素：公钥、私钥、区块链地址
        BlockchainKeyPair newCompanyBlockchainKeyPair = SecureKeyGenerator.generateBubiKeyPair();
        String newCompanyBubiAddress = newCompanyBlockchainKeyPair.getBubiAddress();
        String newCompanyPriKey = newCompanyBlockchainKeyPair.getPriKey();
        String newCompanyPubKey = newCompanyBlockchainKeyPair.getPubKey();
        /**
         * 发起人发起交易
         * 创建企业的区块链地址，并将admin证书的区块链地址添加至
         */
        try {
            // 1：创建交易内的操作：可以是多个。
            CreateAccountOperation.Builder createAccountOperationBuild = new CreateAccountOperation.Builder()
                    .buildDestAddress(newCompanyBubiAddress)
                    // 设置自己操作自己的权限
                    .buildPriMasterWeight(100)
                    //设置权限基础门限值
                    .buildPriTxThreshold(100)
                    //admin签名列表添加上管理员证书
                    .buildAddPriSigner(adminCertBubiAddress, 100);
            CreateAccountOperation createAccountOperation = createAccountOperationBuild.build();

            //1：通过账户池提交交易：
            operationService.newTransactionByAccountPool()
                    .buildAddOperation(createAccountOperation)
                    .commit();
           /*
            //2：交易发起人自己对交易进行签名后发起交易。交易发起人区块链账户
            //eg：a001e4cb3a25dcd5af0d57fb17a71b591bcd6d75d22bf9
            String sponsorAddr = "a001b283997ff78f6ad2ff857efd1183af4a7cbcb73b09";
            String sponsorPub = "b0015363ce09c777f4322c52bcecc4e3050ec2a3da80f30335ce3467339e5604b46515";
            String sponsorPriv = "c00181aab142365deefa41954969d0a516a0e622b5f3fc38d1af621b766d1bf12386d1";
            operationService.newTransaction(sponsorAddr)
                    .buildAddOperation(createAccountOperation)
                    .buildAddSigner(sponsorPub, sponsorPriv)
                    .commit();
            */

            System.out.println("新的企业主体_私钥： " + newCompanyBlockchainKeyPair.getPriKey());
            System.out.println("新的企业主体_公钥： " + newCompanyBlockchainKeyPair.getPubKey());
            System.out.println("新的企业主体_地址： " + newCompanyBlockchainKeyPair.getBubiAddress());
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }

}
