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
     *
     * @param signStr
     * @return
     */
    public static BlockchainKeyPair paseCertSignStr(String signStr) {
        return SecureKeyGenerator.generateCfcaAddress(Base64Utils.encodeToString(signStr.getBytes(Charset.forName("UTF-8"))));
    }

    public static void main(String[] args) {
        String certSignStr = "MIIFMgYJKoZIhvcNAQcCoIIFIzCCBR8CAQExDzANBglghkgBZQMEAgEFADALBgkqhkiG9w0BBwGgggPrMIID5zCCAs+gAwIBAgIFEBCXckcwDQYJKoZIhvcNAQEFBQAwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTEwHhcNMTcxMDIzMDQ0OTM5WhcNMTkxMDIzMDQ0OTM5WjCBnjELMAkGA1UEBhMCY24xFzAVBgNVBAoTDkNGQ0EgVEVTVCBPQ0ExMQ0wCwYDVQQLEwRCVUJJMRQwEgYDVQQLEwtFbnRlcnByaXNlczFRME8GA1UEAwxIMDQxQE45MTMyMDUwODM0NjM4NjM4NU5A6IuP5bee57yY5p2l5peg55WM5bel6Im65ZOB5pyJ6ZmQ5YWs5Y+4QDAwMDAwMDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDANjmPzuBUf3bCeX090K3Y4SsSPbeklcQ3/LXSfBcVEuW8Y7nFgVLyfhONG8diimPtCOGzeieUeQflbSk9gvDuf1b0EbT7PR+vVe6sV8Vvq9gueRtmZ+9QsUdxcblSWb9wMPg2/zDRR9ytMSQ6hpzYVgWxm0I14hJr4t0+7TGj/QIDAQABo4H0MIHxMB8GA1UdIwQYMBaAFM9wnWHrnXwuuPfLAkD3CZ3+M3SAMEgGA1UdIARBMD8wPQYIYIEchu8qAQEwMTAvBggrBgEFBQcCARYjaHR0cDovL3d3dy5jZmNhLmNvbS5jbi91cy91cy0xNC5odG0wOQYDVR0fBDIwMDAuoCygKoYoaHR0cDovL3VjcmwuY2ZjYS5jb20uY24vUlNBL2NybDIxODAxLmNybDALBgNVHQ8EBAMCA+gwHQYDVR0OBBYEFFXco56p6W16FMVwjI5H9K4HWgE4MB0GA1UdJQQWMBQGCCsGAQUFBwMCBggrBgEFBQcDBDANBgkqhkiG9w0BAQUFAAOCAQEANpenbl5r3LvS7ZRafmGxw2ArrFmZvSR20ALUZh8JETcD7vRUlBX+pcgtUg+zMl2E6Ir1WWsvm2n7mJd38WEwnRudWs6G8fj8xULNS32uAnUQrdwqRQDkv43Y3591vqHkNUfCT1Z/x7L0IV8M9XRkBHVPZYhShp8Ebm/KdnQF+m6KBJhGJkPZw8INcCdfaiJDNGNguboTnpO0/Q8TFuhbRDLMeH9LR+zTYmHd1VI+XGAfi7mvSGCNXuNVTl40HrA0DsYDs5eJtLIaj/obVItx/vih6aNQ3K43Wt/lRD8iBQfk8ZEtuEjcLUjJrR+q0x+NpjRSJZ8/h7riCuv5RklCZDGCAQswggEHAgEBMGEwWDELMAkGA1UEBhMCQ04xMDAuBgNVBAoTJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEXMBUGA1UEAxMOQ0ZDQSBURVNUIE9DQTECBRAQl3JHMA0GCWCGSAFlAwQCAQUAMA0GCSqGSIb3DQEBCwUABIGATJJdryIW6ML6cGU2GxNRODiVTMB5g5pI6QgDmigtaSWETE0XACqqwBBKuF1Ich2OIdq4bGmCtZ0oGp+8BeXC14+HiGGl6wJedlsiC8ggSSyCziqNzmiBPAqVFEG4cL1JYpiAhyCngbR3Z7w9Nd78A6PGxUeAaEMAqGnsIEUd56g=";
        System.out.println(AdapterBlockSDKUtil.paseCertSignStr(certSignStr));
    }
}
