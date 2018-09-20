package com.prosayj.springboot.blockchain_java.blockchain_part1;


import com.prosayj.springboot.constants.LoggerModelEnum;
import com.prosayj.springboot.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @Date 22:25 2018/7/28
 * @since 1.0.0
 */

public class BlockChainTest {
    public static final Logger loger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_BLOCKCHAIN.getModuleNickName());
    public static void main(String[] args) {
        //first，第一个区块又称为创世区块
        Block firstBlock = new Block("first", "0");
        loger.info("Hash for block 1: {}" + firstBlock.hash);
        loger.info(BeanUtils.objectConvertToString(firstBlock));

        //second
        Block secondBlock = new Block("second", firstBlock.hash);
        loger.info("Hash for block 2: {}" + secondBlock.hash);

        //third
        Block thirdBlock = new Block("third", secondBlock.hash);
        loger.info("Hash for block 3: {}" + thirdBlock.hash);
    }
}
