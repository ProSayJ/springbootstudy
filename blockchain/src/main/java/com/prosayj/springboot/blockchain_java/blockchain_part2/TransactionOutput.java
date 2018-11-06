package com.prosayj.springboot.blockchain_java.blockchain_part2;

import com.prosayj.springboot.utils.StringUtil;

import java.security.PublicKey;

/**
 * @author yangjian
 * @description 区块
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:30
 * @since 1.0.0
 */
public class TransactionOutput {

    public String id;

    /**
     * also known as the new owner of these coins
     */
    public PublicKey reciepient;

    /**
     * the amount of coins they own
     */
    public float value;

    /**
     * the id of the transaction this output was created in
     */
    public String parentTransactionId;


    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient) + Float.toString(value) + parentTransactionId);
    }

    /**
     * Check if coin belongs to you
     */
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == reciepient);
    }
}
