package com.prosayj.springboot.blockchain_java.blockchain_part1;

import com.prosayj.springboot.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yangjian
 * @description 区块
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:24
 * @since 1.0.0
 */
public class Block {
    public static final Logger loger = LoggerFactory.getLogger(Block.class);
    /**
     * 当前区块的hash
     */
    public String hash;

    /**
     * 前一个区块的hash
     */
    public String previousHash;

    /**
     * 当前区块的数据
     * our data will be a simple message.
     */
    private String data;

    /**
     * 时间戳
     * as number of milliseconds since 1/1/1970.
     */
    private long timeStamp;
    /**
     * 工作量证明常数
     */
    private int nonce;


    public Block(String hash, String previousHash, String data) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
    }

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
        //Making sure we do this after we set the other values.
        this.hash = calculateHash();
    }

    /**
     * @description 计算hash值
     * @author yangjian
     * @Date 23:11 2018/7/28
     * @since 1.0.0
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data);
        return calculatedhash;
    }

    /**
     * @description 工作量证明
     * @author yangjian
     * @Date 23:10 2018/7/28
     * @since 1.0.0
     */
    public void mineBlock(int difficulty) {
        //Create a string with difficulty * "0" 目标值
        String target = new String(new char[difficulty]).replace('\0', '0');

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();

        }
        loger.info("Block Mined!!! : " + hash);
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", data='" + data + '\'' +
                ", timeStamp=" + timeStamp +
                ", nonce=" + nonce +
                '}';
    }
}
