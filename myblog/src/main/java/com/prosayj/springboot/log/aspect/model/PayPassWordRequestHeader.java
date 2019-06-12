package com.prosayj.springboot.log.aspect.model;

/**
 * @author yangjian
 * @description 交易密码请求体
 * @Date 10:19 2019/6/12
 * @since 1.0.0
 */
public class PayPassWordRequestHeader {
    /**
     * 支付密码
     */
    private String txPsw;
    /**
     * RSA 公钥
     */
    private String pubKey;

    public String getTxPsw() {
        return txPsw;
    }

    public void setTxPsw(String txPsw) {
        this.txPsw = txPsw;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }
}
