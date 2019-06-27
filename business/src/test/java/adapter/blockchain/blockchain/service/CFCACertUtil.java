package adapter.blockchain.blockchain.service;

import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.Base64;
import cfca.sadk.util.Signature;
import cfca.sadk.x509.certificate.X509Cert;
import cn.bubi.encryption.BubiKey;

import java.util.Date;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/27 下午 12:24
 * @since 1.0.0
 */
public class CFCACertUtil {
    public CFCACertUtil() {
    }

    /**
     * 验证签名是否正确
     *
     * @param signed
     * @param sourceData
     * @return
     */
    public static Boolean verifySign(byte[] signed, byte[] sourceData) {
        X509Cert cert = verifySignAndGetX509Cert(signed, sourceData);
        return cert != null ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 通过证书的签名串和原文解析证书信息
     *
     * @param signed
     * @param sourceData
     * @return
     */
    public static X509Cert verifySignAndGetX509Cert(byte[] signed, byte[] sourceData) {
        Signature sign = new Signature();

        try {
            JCrypto.getInstance().initialize("JSOFT_LIB", (Object) null);
            Session session = JCrypto.getInstance().openSession("JSOFT_LIB");
            return !sign.p7VerifyMessageDetach(sourceData, signed, session) ? null : sign.getSignerCert();
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static Boolean verifySignAndCheckExpiration(byte[] signed, byte[] sourceData) {
        X509Cert cert = verifySignAndGetX509Cert(signed, sourceData);
        return cert == null ? Boolean.FALSE : checkCertValidDate(cert.getNotBefore(), cert.getNotAfter());
    }

    public static Boolean verifySignAndAppointCert(byte[] signed, byte[] sourceData, String appointCertSerialNum, String appointCertIssuerDn) {
        X509Cert cert = verifySignAndGetX509Cert(signed, sourceData);
        if (cert == null) {
            return Boolean.FALSE;
        } else {
            Boolean checkExpiration = checkCertValidDate(cert.getNotBefore(), cert.getNotAfter());
            if (Boolean.FALSE.equals(checkExpiration)) {
                return Boolean.FALSE;
            } else if (appointCertSerialNum != null && appointCertSerialNum.equals(cert.getStringSerialNumber())) {
                return appointCertIssuerDn != null && appointCertIssuerDn.equals(cert.getIssuer()) ? Boolean.TRUE : Boolean.FALSE;
            } else {
                return Boolean.FALSE;
            }
        }
    }

    public static String generateCfcaPublic(byte[] signed) {
        try {
            BubiKey bubiKey = new BubiKey(signed);
            return bubiKey.getB16PublicKey();
        } catch (Exception var2) {
            var2.printStackTrace();
            throw new RuntimeException("Error occurred on generate CFCA address! --[" + var2.getClass().getName() + "] --" + var2.getMessage(), var2);
        }
    }

    private static Boolean checkCertValidDate(Date validStartTime, Date validEndTime) {
        Date checkDate = new Date();
        if (validStartTime != null && checkDate.before(validStartTime)) {
            return Boolean.FALSE;
        } else {
            return validEndTime != null && checkDate.after(validEndTime) ? Boolean.FALSE : Boolean.TRUE;
        }
    }

    public static void main(String[] args) {
        String sourceData = "sdf";
        String signData = "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";
        String rightSerialNum = "1028703667";
        String wrongSerialNum = "1028696561";
        String isuuerDn = "CN=CFCA TEST OCA1, O=China Financial Certification Authority, C=CN";

        try {

            System.out.println("解析证书信息" + verifySignAndGetX509Cert(Base64.encode(sourceData.getBytes()), Base64.encode(signData.getBytes())));
            System.out.println("预期true：" + verifySign(signData.getBytes(), sourceData.getBytes()));
            System.out.println("预期true：" + verifySignAndAppointCert(signData.getBytes(), sourceData.getBytes(), rightSerialNum, isuuerDn));
            System.out.println("预期false：" + verifySignAndAppointCert(signData.getBytes(), sourceData.getBytes(), wrongSerialNum, isuuerDn));
            System.out.println("公钥：" + generateCfcaPublic(signData.getBytes()));
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }
}
