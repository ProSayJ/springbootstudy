package com.prosayj.springboot.blockchain_java.blockchain_part2;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:30
 * @since 1.0.0
 */
public class TransactionInput {
    /**
     * Reference to TransactionOutputs -> transactionId
     */
    public String transactionOutputId;

    /**
     * Contains the Unspent transaction output
     */
    public TransactionOutput UTXO;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}
