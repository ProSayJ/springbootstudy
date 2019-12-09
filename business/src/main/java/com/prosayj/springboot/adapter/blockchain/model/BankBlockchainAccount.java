package com.prosayj.springboot.adapter.blockchain.model;

/**
 * @description 银行账户对应的区块链账户方案，有两个账户
 * @since 1.0.0
 */
public class BankBlockchainAccount {
    /**
     * 银行账户对应的区块链账户
     */
    private String account;
    /**
     * account账户签名列表中，限制了只能发起payment交易的账户
     */
    private String paymentThresholdAddress;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPaymentThresholdAddress() {
        return paymentThresholdAddress;
    }

    public void setPaymentThresholdAddress(String paymentThresholdAddress) {
        this.paymentThresholdAddress = paymentThresholdAddress;
    }
}
