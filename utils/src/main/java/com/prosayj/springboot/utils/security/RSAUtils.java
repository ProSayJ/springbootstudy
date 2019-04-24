package com.prosayj.springboot.utils.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.com
 * @creatTime 2018/11/29 21:41
 * @since 1.0.0
 */
public class RSAUtils {
    public static final String ALG_RSA = "RSA";
    public static final String KEYPAIR_PUBKEY = "pubKey";
    public static final String KEYPAIR_PRIKEY = "priKey";

    /**
     * 生成公私钥对
     *
     * @param keySize
     * @return
     */
    public static RSAKeyPair generateKey(int keySize) {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALG_RSA);
            keyPairGen.initialize(keySize, new SecureRandom());
            KeyPair keyPair = keyPairGen.generateKeyPair();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            return new RSAKeyPair(publicKey.getEncoded(), privateKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    /**
     * 加密
     *
     * @param data
     * @param publicKey
     * @return
     */
    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) {
        if (publicKey == null) {
            throw new IllegalArgumentException("Public key is empty!");
        }
        try {
            RSAPublicKey pubKey = loadPublicKey(publicKey);
            Cipher cipher = Cipher.getInstance(ALG_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            return cipher.doFinal(data);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 解密
     *
     * @param cipherData
     * @param privateKey
     * @return
     */
    public static byte[] decryptByPrivateKey(byte[] cipherData, byte[] privateKey) {
        if (privateKey == null) {
            throw new IllegalArgumentException("Private key is empty!");
        }
        try {
            RSAPrivateKey privKey = loadPrivateKey(privateKey);
            Cipher cipher = Cipher.getInstance(ALG_RSA);
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            return cipher.doFinal(cipherData);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static RSAPublicKey loadPublicKey(byte[] pubKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALG_RSA);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKey);
        return (RSAPublicKey) keyFactory.generatePublic(keySpec);
    }

    private static RSAPrivateKey loadPrivateKey(byte[] priKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(priKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ALG_RSA);
        return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
    }
}

