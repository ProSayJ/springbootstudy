package com.prosayj.springboot.blockchain_java.blockchain_part2;


import com.prosayj.springboot.baseutils.StringUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yangjian
 * @description 区块
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:28
 * @since 1.0.0
 */
public class Block {
    public String hash;
    public String previousHash;
    public String merkleRoot;
    //our data will be a simple message.
    public ArrayList<Transaction> transactions = new ArrayList<>();
    public long timeStamp; //as number of milliseconds since 1/1/1970.
    public int nonce;

    //Block Constructor.
    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();

        //Making sure we do this after we set the other values.
        this.hash = calculateHash();
    }

    //Calculate new hash based on blocks contents
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        merkleRoot
        );
        return calculatedhash;
    }

    //Increases nonce value until hash target is reached.
    public void mineBlock(int difficulty) {
        merkleRoot = getMerkleRoot(transactions);
        //Create a string with difficulty * "0"
        String target = StringUtil.getDificultyString(difficulty);
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }

    //Add transactions to this block
    public boolean addTransaction(Transaction transaction) {
        //process transaction and check if valid, unless block is genesis block then ignore.
        if (transaction == null) {
            return false;
        }
        if ((previousHash != "0")) {
            if ((transaction.processTransaction() != true)) {
                System.out.println("Transaction failed to process. Discarded.");
                return false;
            }
        }

        transactions.add(transaction);
        System.out.println("Transaction Successfully added to Block");
        return true;
    }

    private static String getMerkleRoot(ArrayList<Transaction> transactions) {
        int count = transactions.size();

        List<String> previousTreeLayer = new ArrayList<>();
        for (Transaction transaction : transactions) {
            previousTreeLayer.add(transaction.transactionId);
        }
        List<String> treeLayer = previousTreeLayer;

        while (count > 1) {
            treeLayer = new ArrayList<String>();
            for (int i = 1; i < previousTreeLayer.size(); i += 2) {
                treeLayer.add(StringUtil.applySha256(previousTreeLayer.get(i - 1) + previousTreeLayer.get(i)));
            }
            count = treeLayer.size();
            previousTreeLayer = treeLayer;
        }

        String merkleRoot = (treeLayer.size() == 1) ? treeLayer.get(0) : "";
        return merkleRoot;
    }

}
