package com.prosayj.springboot.blockchain_java.blockchain_part1;


import com.prosayj.springboot.constants.LoggerModelEnum;
import com.prosayj.springboot.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:24
 * @since 1.0.0
 */
public class BlockChainListTest {
    public static final Logger loger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_BLOCKCHAIN.getModuleNickName());
    //创建区块链
    public static ArrayList<Block> blockChain = new ArrayList();
    //工作量证明常数
    public static int difficulty = 5;

    public static void main(String[] args) {
        //构造创始区块
        blockChain.add(new Block("first", "0"));
        loger.info("Trying to Mine block 1... ");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("second", blockChain.get(blockChain.size() - 1).hash));
        loger.info("Trying to Mine block 2... ");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("third", blockChain.get(blockChain.size() - 1).hash));
        loger.info("Trying to Mine block 3... ");
        blockChain.get(2).mineBlock(difficulty);


        loger.info("Blockchain is Valid: " + isChainValid());
//        String json = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);

        loger.info(BeanUtils.toJson(blockChain));
    }

    /**
     * @description 循环区块链中的所有区块并且比较hash值，这个方法用来检查hash值是否是于计算出来的hash值相等，
     * 同时previousHash值是否和前一个区块的hash值相等
     * @author yangjian
     * @Date 23:07 2018/7/28
     * @since 1.0.0
     */
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        boolean flag = true;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //循环遍历列表检验hash
        for (int i = 1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i - 1);
            //比较注册的hash和计算的hash
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                loger.error("当前hash不相等");
                flag = false;
            }
            //比较当前的前一个hash与注册的前一个hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                loger.error("前一个hash不相等:previousBlock:{},currentBlock:{}", previousBlock.hash, currentBlock, previousBlock);
                flag = false;
            }

            //check if hash is solved
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                flag = false;
            }
        }
        return flag;
    }
}
