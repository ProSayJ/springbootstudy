

package com.prosayj.springboot.adapter.blockchain.service;


import com.prosayj.springboot.adapter.blockchain.constant.TransactionBlob;
import com.prosayj.springboot.adapter.blockchain.model.BankBlockchainAccount;
import com.prosayj.springboot.adapter.blockchain.model.BlockchainAccount;

import java.util.List;

/**
 * @author wangjingru
 * @description 区块链sdk调用适配层
 * @email wangjingru@bubi.cn
 * @creatTime 2017/11/28 10:28
 * @since 1.0.0
 */
public interface BlockchainSdkAdapter {
    /**
     * 为目标账户的签名列表添加一个地址，并设置默认的权重
     * @param targetAddress 目标区块链账户
     * @param signerAddress 签名人区块链账户
     * @return              待签名blob
     */
    TransactionBlob addSignerAndSetDefaultWeight(String targetAddress, String signerAddress);

    /**
     * 为目标账户的签名列表添加一个地址，并设置权重
     * @param targetAddress 目标区块链账户
     * @param signerAddress 签名人区块链账户
     * @param weight        该签名人的权重
     * @return              待签名blob
     */
    TransactionBlob addSignerAndSetWeight(String targetAddress, String signerAddress, Integer weight);

    /**
     * 从目标账户的签名列表移除一个地址
     * @param targetAddress 目标区块链账户
     * @param signerAddress 待移除的签名人区块链账户
     * @return              待签名的blob
     */
    TransactionBlob removeSigner(String targetAddress, String signerAddress);

    /**
     * 交易提交
     * @param hash          待提交交易hash
     * @param signStr       签名串
     * @return              返回提交结果
     */
    Boolean transactionSubmit(String hash, byte[] signStr);

    /**
     * 修改所有目标账户的签名列表
     * @param sponsorAddress        交易发起方区块链账户
     * @param targetAddressList     目标账户区块链账户
     * @param signerAddress         待修改的签名人区块链账户
     * @param weight                待设置权重
     * @return                      待签名数据
     */
    TransactionBlob addSignerAndSetWeight4Targets(String sponsorAddress, List<String> targetAddressList, String signerAddress, Integer weight);

    /**
     * 为所有目标账户的签名列表添加一个签名人，并设置为默认权限
     * @param sponsorAddress        交易发起方区块链账户
     * @param targetAddressList     目标账户区块链账户
     * @param signerAddress         待修改的签名人区块链账户
     * @return                      待签名数据
     */
    TransactionBlob addSignerAndSetDefaultWeight4Targets(String sponsorAddress, List<String> targetAddressList, String signerAddress);

    /**
     * 从所有目标账户的签名列表中移除目标签名人
     * @param sponsorAddress        交易发起方区块链账户
     * @param targetAddressList     目标账户区块链账户
     * @param signerAddress         待移除的签名人区块链账户
     * @return                      待签名数据
     */
    TransactionBlob removeSigner4Targets(String sponsorAddress, List<String> targetAddressList, String signerAddress);

    /**
     * 根据证书签名串，获得签名证书的公钥及区块链地址
     * @param base64SignStr   签名串
     * @return          公钥及地址
     */
    BlockchainAccount generateCfcaAddress(String base64SignStr);

    /**
     * 为某主体的银行账户，按指定方案创建对应的区块链账户
     * @param ownerBlockchainAddress    拥有者的区块链地址（企业/个人 主体区块链地址）
     * @return                          银行账户相关区块链地址
     */
    BankBlockchainAccount createBankBlockchainAccount(String ownerBlockchainAddress);

    /**
     * 创建主体区块链账户
     * @param signAddress   要放到签名列表中的地址（业务方案为证书地址）
     * @return              主体区块链账户三元素
     */
    BlockchainAccount createBlockchainAccount4Entity(String signAddress);

    /**
     * 将指定账户地址注册到区块链上
     * @param address   待注册的区块链地址
     * @return          注册成功/已注册-true；注册失败-false
     */
    Boolean registerBlockchainAddress(String address);

    /**
     * 为所有目标账户的签名列表添加一个签名人，并设置为默认权限
     * @param sponsorAddress        交易发起方区块链账户
     * @param targetAddressList     目标账户区块链账户
     * @param addSignerCertAddressList         待添加的证书区块链地址列表
     * @param removeSignerCertAddressList         待移除的证书区块链地址列表
     * @return                      待签名数据
     */
    TransactionBlob addOrRemoveSignerAndSetDefaultWeight4Targets(String sponsorAddress, List<String> targetAddressList, List<String> addSignerCertAddressList, List<String> removeSignerCertAddressList);

    /**
     * 同步交易：修改操作账户签名列表：默认权重为100
     * @param sponsorAccount            操作账户及公私钥
     * @param addSignerCertAddress      待添加的证书区块链地址
     * @param removeSignerCertAddress   待移除的证书区块链地址
     * @return                          true-修改成功；false-修改失败
     */
    Boolean addOrRemoveSignerAndSetDefaultAdminWeightSycn(BlockchainAccount sponsorAccount, String addSignerCertAddress, List<String> removeSignerCertAddress);
}
