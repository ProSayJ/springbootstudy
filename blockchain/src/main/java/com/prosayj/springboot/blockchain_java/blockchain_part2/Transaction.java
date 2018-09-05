package com.prosayj.springboot.blockchain_java.blockchain_part2;


import com.prosayj.springboot.baseutils.StringUtil;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description 交易类
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:28
 * @since 1.0.0
 */
public class Transaction {

    //Contains a hash of transaction*
    public String transactionId;

    //Senders address/public key.
    public PublicKey sender;

    //Recipients address/public key.
    public PublicKey reciepient;

    //Contains the amount we wish to send to the recipient.
    public float value;

    //This is to prevent anybody else from spending funds in our wallet.
    public byte[] signature;

    public List<TransactionInput> inputs = new ArrayList<>();
    public List<TransactionOutput> outputs = new ArrayList<>();

    //A rough count of how many transactions have been generated
    private static int sequence = 0;

    // Constructor:
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    public boolean processTransaction() {
        if (verifySignature() == false) {
            System.out.println("#Transaction Signature failed to verify");
            return false;
        }

        //Gathers transaction inputs (Making sure they are unspent):
        for (TransactionInput i : inputs) {
            i.UTXO = NoobChain.UTXOs.get(i.transactionOutputId);
        }

        //Checks if transaction is valid:
        if (getInputsValue() < NoobChain.minimumTransaction) {
            System.out.println("Transaction Inputs to small: " + getInputsValue());
            return false;
        }

        //Generate transaction outputs:
        //get value of inputs then the left over change:
        float leftOver = getInputsValue() - value;
        transactionId = calulateHash();
        //send value to recipient
        outputs.add(new TransactionOutput(this.reciepient, value, transactionId));
        //send the left over 'change' back to sender
        outputs.add(new TransactionOutput(this.sender, leftOver, transactionId));

        //Add outputs to Unspent list
        for (TransactionOutput o : outputs) {
            NoobChain.UTXOs.put(o.id, o);
        }

        //Remove transaction inputs from UTXO lists as spent:
        for (TransactionInput i : inputs) {
            //if Transaction can't be found skip it
            if (i.UTXO == null) {
                continue;
            }
            NoobChain.UTXOs.remove(i.UTXO.id);
        }
        return true;
    }

    public float getInputsValue() {
        float total = 0;
        for (TransactionInput i : inputs) {
            //if Transaction can't be found skip it, This behavior may not be optimal.
            if (i.UTXO == null) {
                continue;
            }
            total += i.UTXO.value;
        }
        return total;
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        signature = StringUtil.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + Float.toString(value);
        return StringUtil.verifyECDSASig(sender, data, signature);
    }

    public float getOutputsValue() {
        float total = 0;
        for (TransactionOutput o : outputs) {
            total += o.value;
        }
        return total;
    }

    private String calulateHash() {
        //increase the sequence to avoid 2 identical transactions having the same hash
        sequence++;
        return StringUtil.applySha256(
                StringUtil.getStringFromKey(sender) +
                        StringUtil.getStringFromKey(reciepient) +
                        Float.toString(value) + sequence
        );
    }
}
