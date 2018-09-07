package com.prosayj.springboot.blockchain_java.blockchain_part1;


import com.prosayj.springboot.utils.BeanUtils;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @Date 22:25 2018/7/28
 * @since 1.0.0
 */

public class BlockChainTest {

    public static void main(String[] args) {
        //first，第一个区块又称为创世区块
        Block firstBlock = new Block("first", "0");
        System.out.println("Hash for block 1: " + firstBlock.hash);
        System.out.println(BeanUtils.toJson(firstBlock));

        //second
        Block secondBlock = new Block("second", firstBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        //third
        Block thirdBlock = new Block("third", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);
    }
}
