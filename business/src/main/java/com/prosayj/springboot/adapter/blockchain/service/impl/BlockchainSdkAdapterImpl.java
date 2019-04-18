package com.prosayj.springboot.adapter.blockchain.service.impl;

import cn.bubi.access.adaptation.blockchain.bc.OperationTypeV3;
import cn.bubi.access.adaptation.blockchain.bc.response.Account;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import cn.bubi.sdk.core.exception.SdkException;
import cn.bubi.sdk.core.operation.BcOperation;
import cn.bubi.sdk.core.operation.OperationFactory;
import cn.bubi.sdk.core.operation.impl.CreateAccountOperation;
import cn.bubi.sdk.core.operation.impl.SetSignerWeightOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.spi.BcQueryService;
import cn.bubi.sdk.core.transaction.Transaction;
import cn.bubi.sdk.core.transaction.TransactionContent;
import com.alibaba.fastjson.JSONObject;
import com.prosayj.springboot.adapter.blockchain.config.BlockchainSdkConfig;
import com.prosayj.springboot.adapter.blockchain.constant.BlockchainConstant;
import com.prosayj.springboot.adapter.blockchain.constant.TransactionBlob;
import com.prosayj.springboot.adapter.blockchain.model.BankBlockchainAccount;
import com.prosayj.springboot.adapter.blockchain.model.BlockchainAccount;
import com.prosayj.springboot.adapter.blockchain.service.BlockchainSdkAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @description 区块链sdk调用适配层
 * @creatTime 2017/11/28 11:04
 * @since 1.0.0
 */
@Service
public class BlockchainSdkAdapterImpl implements BlockchainSdkAdapter {
    private static final Logger logger = LoggerFactory.getLogger("bunuo.adapter");
    @Autowired
    private BlockchainSdkConfig blockchainSdkConfig;
    @Autowired
    private BcOperationService operationService;
    @Autowired
    private BcQueryService bcQueryService;

    @Override
    public TransactionBlob addSignerAndSetDefaultWeight(String targetAddress, String signerAddress) {
        return addSignerAndSetWeight(targetAddress, signerAddress, BlockchainConstant.DEFAULT_SIGNER_WEIGHT);
    }

    @Override
    public TransactionBlob addSignerAndSetWeight(String targetAddress, String signerAddress, Integer weight) {
        logger.info("添加签名列表-调用区块链sdk生成待签名blob-start:targetAddress-{},signerAddress-{},weight-{}", targetAddress, signerAddress, weight);
        try {
            Transaction transaction = operationService
                    .newTransaction(targetAddress)
                    .buildAddOperation(OperationFactory.newSetSignerWeightOperation(signerAddress, weight));
            cn.bubi.sdk.core.transaction.model.TransactionBlob transactionBlob = transaction
                    .buildFinalNotifySeqOffset(blockchainSdkConfig.getDefaultFinalNotifySeqOffset())
                    .generateBlob();
            //暂存transaction
            TransactionContent.put(transactionBlob.getHash(), transaction);
            TransactionBlob result = new TransactionBlob();
            result.setHash(transactionBlob.getHash());
            result.setHexBlob(transactionBlob.getHex());
            logger.info("添加签名列表-调用区块链sdk生成待签名blob-end:targetAddress-{},signerAddress-{},weight-{},result-{}",
                    targetAddress, signerAddress, weight, JSONObject.toJSONString(result));
            return result;
        } catch (Exception e) {
            logger.error("添加签名列表-调用区块链sdk生成待签名blob失败，参数：targetAddress-{}, signerAddress-{}, weight-{}", targetAddress, signerAddress, weight);
            return null;
        }
    }

    @Override
    public TransactionBlob removeSigner(String targetAddress, String signerAddress) {
        return addSignerAndSetWeight(targetAddress, signerAddress, BlockchainConstant.REMOVE_SIGNER_WEIGHT);
    }

    @Override
    public Boolean transactionSubmit(String hash, byte[] signStr) {
        try {
            logger.info("提交底层交易-start:hash-{}", hash);
            Transaction transaction = TransactionContent.get(hash);
            BlockchainAccount signerAccount = generateCfcaAddress(Base64Utils.encodeToString(signStr));
            transaction.buildAddDigest(signerAccount.getPublicKey(), signStr).commit();
            logger.info("提交底层交易-end:hash-{}", hash);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("提交交易失败，参数：hash-{}，签名串base64编码-{}", hash, Base64Utils.encodeToString(signStr), e);
            return Boolean.FALSE;
        }
    }

    @Override
    public TransactionBlob addSignerAndSetWeight4Targets(String sponsorAddress, List<String> targetAddressList, String signerAddress, Integer weight) {
        try {
            logger.info("添加签名列表-调用区块链sdk生成待签名blob-start:targetAddress-{},signerAddress-{},weight-{}",
                    JSONObject.toJSONString(targetAddressList), signerAddress, weight);
            Transaction transaction = operationService
                    .newTransaction(sponsorAddress);
            for (String targetAddress : targetAddressList) {
                BcOperation operation = new SetSignerWeightOperation
                        .Builder()
                        .buildOperationSourceAddress(targetAddress)
                        .buildAddSigner(signerAddress, weight)
                        .build();
                transaction.buildAddOperation(operation);
            }
            cn.bubi.sdk.core.transaction.model.TransactionBlob transactionBlob = transaction
                    .buildFinalNotifySeqOffset(blockchainSdkConfig.getDefaultFinalNotifySeqOffset())
                    .generateBlob();
            //暂存transaction
            TransactionContent.put(transactionBlob.getHash(), transaction);
            TransactionBlob result = new TransactionBlob();
            result.setHash(transactionBlob.getHash());
            result.setHexBlob(transactionBlob.getHex());
            logger.info("添加签名列表-调用区块链sdk生成待签名blob-end:targetAddress-{},signerAddress-{},weight-{},result-{}",
                    JSONObject.toJSONString(targetAddressList), signerAddress, weight, JSONObject.toJSONString(result));
            return result;
        } catch (Exception e) {
            logger.error("添加签名列表-调用区块链sdk生成待签名blob失败，参数：targetAddress-{}, signerAddress-{}, weight-{}",
                    JSONObject.toJSONString(targetAddressList), signerAddress, weight, e);
            return null;
        }
    }

    @Override
    public TransactionBlob addSignerAndSetDefaultWeight4Targets(String sponsorAddress, List<String> targetAddressList, String signerAddress) {
        return addSignerAndSetWeight4Targets(sponsorAddress, targetAddressList, signerAddress, BlockchainConstant.DEFAULT_SIGNER_WEIGHT);
    }

    @Override
    public TransactionBlob removeSigner4Targets(String sponsorAddress, List<String> targetAddressList, String signerAddress) {
        return addSignerAndSetWeight4Targets(sponsorAddress, targetAddressList, signerAddress, BlockchainConstant.REMOVE_SIGNER_WEIGHT);
    }

    @Override
    public BlockchainAccount generateCfcaAddress(String base64SignStr) {
        BlockchainKeyPair blockchainKeyPair = SecureKeyGenerator.generateCfcaAddress(base64SignStr);
        BlockchainAccount blockchainAccount = new BlockchainAccount();
        blockchainAccount.setAddress(blockchainKeyPair.getBubiAddress());
        blockchainAccount.setPublicKey(blockchainKeyPair.getPubKey());
        return blockchainAccount;
    }

    @Override
    public BankBlockchainAccount createBankBlockchainAccount(String ownerBlockchainAddress) {
        if (StringUtils.isEmpty(ownerBlockchainAddress)) {
            logger.error("create blockchain account belong to bank account fail! reason : ownerBlockchainAddress is null");
            return null;
        }
        //为银行账户生成区块链账户三元素
        BlockchainKeyPair bankAccount = SecureKeyGenerator.generateBubiKeyPair();
        //生成控制权限的区块链账户
        BlockchainKeyPair payment = SecureKeyGenerator.generateBubiKeyPair();
        try {
            //组装创建payment账户的操作
            CreateAccountOperation createAccountOperation = new CreateAccountOperation.Builder()
                    .buildDestAddress(payment.getBubiAddress())
                    //拥有者的主体地址需添加到签名列表中，且权限最高
                    .buildAddPriSigner(ownerBlockchainAddress, 10500)
                    .buildPriTxThreshold(50)
                    .build();
            //组装创建银行账户对应的区块链账户的操作
            CreateAccountOperation createAccountOperation2 = new CreateAccountOperation.Builder()
                    .buildDestAddress(bankAccount.getBubiAddress())
                    //限制交易类型门限
                    .buildPriTxThreshold(50)
                    .buildAddPriTypeThreshold(OperationTypeV3.PAYMENT, 100)
                    .buildAddPriTypeThreshold(OperationTypeV3.SET_SIGNER_WEIGHT, 10000)
                    .buildAddPriTypeThreshold(OperationTypeV3.SET_THRESHOLD, 10000)
                    //签名列表中需有拥有者的主体地址及payment账户
                    .buildAddPriSigner(ownerBlockchainAddress, 10500)
                    //payment账户只能发起类型为payment的交易
                    .buildAddPriSigner(payment.getBubiAddress(), 100)
                    .build();
            operationService.newTransactionByAccountPool()
                    .buildAddOperation(createAccountOperation)
                    .buildAddOperation(createAccountOperation2)
                    .commit();
            //组装返回值
            BankBlockchainAccount result = new BankBlockchainAccount();
            result.setAccount(bankAccount.getBubiAddress());
            result.setPaymentThresholdAddress(payment.getBubiAddress());
            return result;
        } catch (SdkException e) {
            logger.error("create blockchain account belong to bank account fail! reason : ", e);
        }
        return null;
    }

    @Override
    public BlockchainAccount createBlockchainAccount4Entity(String signAddress) {

        //生成主体区块链账户三元素
        BlockchainKeyPair entity = SecureKeyGenerator.generateBubiKeyPair();
        //组装创建账户操作
        try {
            CreateAccountOperation.Builder createAccountOperationBuild = new CreateAccountOperation.Builder()
                    .buildDestAddress(entity.getBubiAddress())
                    // 权限部分
                    .buildPriMasterWeight(100)
                    .buildPriTxThreshold(100);
            if (!StringUtils.isEmpty(signAddress)) {
                //如果证书地址为null，则不添加
                createAccountOperationBuild.buildAddPriSigner(signAddress, 100);
            }
            operationService.newTransactionByAccountPool()
                    .buildAddOperation(createAccountOperationBuild.build())
                    .commit();
            //组装返回值
            BlockchainAccount entityAccount = new BlockchainAccount();
            entityAccount.setAddress(entity.getBubiAddress());
            entityAccount.setPublicKey(entity.getPubKey());
            entityAccount.setPrivateKey(entity.getPriKey());
            return entityAccount;
        } catch (SdkException e) {
            logger.error("create blockchain account belong to entity fail! reason : ", e);
        }
        return null;
    }

    @Override
    public Boolean registerBlockchainAddress(String address) {
        //查询该区块链账户是否已存在
        Account account = bcQueryService.getAccount(address);
        if (account != null) {
            //已存在
            return Boolean.TRUE;
        }
        //区块链账户不存在，组装创建账户操作
        try {
            CreateAccountOperation createAccountOperation = new CreateAccountOperation.Builder()
                    .buildDestAddress(address)
                    // 权限部分
                    .buildPriMasterWeight(100)
                    .buildPriTxThreshold(100)
                    .build();
            operationService.newTransactionByAccountPool()
                    .buildAddOperation(createAccountOperation)
                    .commit();
            return Boolean.TRUE;
        } catch (SdkException e) {
            logger.error("create blockchain account belong to entity fail! reason : ", e);
        }
        return Boolean.FALSE;
    }

    @Override
    public TransactionBlob addOrRemoveSignerAndSetDefaultWeight4Targets(String sponsorAddress, List<String> targetAddressList,
                                                                        List<String> addSignerCertAddressList, List<String> removeSignerCertAddressList) {
        try {
            logger.info("添加签名列表-调用区块链sdk生成待签名blob-start:targetAddress-{},addSignerAddress-{},removeSignerAddress-{}",
                    JSONObject.toJSONString(targetAddressList), JSONObject.toJSONString(addSignerCertAddressList), JSONObject.toJSONString(removeSignerCertAddressList));
            Transaction transaction = operationService
                    .newTransaction(sponsorAddress);
            for (String targetAddress : targetAddressList) {

                for (String addSignerAddress : addSignerCertAddressList) {
                    BcOperation operation = new SetSignerWeightOperation
                            .Builder()
                            .buildOperationSourceAddress(targetAddress)
                            .buildAddSigner(addSignerAddress, BlockchainConstant.DEFAULT_SIGNER_WEIGHT)
                            .build();
                    transaction.buildAddOperation(operation);
                }

                for (String removeSignerAddress : removeSignerCertAddressList) {
                    BcOperation operation = new SetSignerWeightOperation
                            .Builder()
                            .buildOperationSourceAddress(targetAddress)
                            .buildAddSigner(removeSignerAddress, BlockchainConstant.REMOVE_SIGNER_WEIGHT)
                            .build();
                    transaction.buildAddOperation(operation);
                }

            }
            cn.bubi.sdk.core.transaction.model.TransactionBlob transactionBlob = transaction
                    .buildFinalNotifySeqOffset(blockchainSdkConfig.getDefaultFinalNotifySeqOffset())
                    .generateBlob();
            //暂存transaction
            TransactionContent.put(transactionBlob.getHash(), transaction);
            TransactionBlob result = new TransactionBlob();
            result.setHash(transactionBlob.getHash());
            result.setHexBlob(transactionBlob.getHex());
            logger.info("添加签名列表-调用区块链sdk生成待签名blob-end:targetAddress-{},addSignerAddress-{},removeSignerAddress-{},result-{}",
                    JSONObject.toJSONString(targetAddressList), JSONObject.toJSONString(addSignerCertAddressList), JSONObject.toJSONString(removeSignerCertAddressList), JSONObject.toJSONString(result));
            return result;
        } catch (Exception e) {
            logger.error("添加签名列表-调用区块链sdk生成待签名blob失败，参数：targetAddress-{}, addSignerAddress-{},removeSignerAddress-{}",
                    JSONObject.toJSONString(targetAddressList), JSONObject.toJSONString(addSignerCertAddressList), JSONObject.toJSONString(removeSignerCertAddressList), e);
            return null;
        }

    }

    @Override
    public Boolean addOrRemoveSignerAndSetDefaultAdminWeightSycn(BlockchainAccount sponsorAccount, String addSignerCertAddress, List<String> removeSignerCertAddress) {
        String sponsorAddress = sponsorAccount.getAddress();
        logger.info("修改签名列表（同步交易）-修改目标账户签名列表-start：targetAddress-{}, addSignerCertAddress-{} ,removeSignerCertAddress-{}",
                sponsorAddress, addSignerCertAddress, removeSignerCertAddress);
        try {
            //组装操作
            SetSignerWeightOperation.Builder operation = new SetSignerWeightOperation
                    .Builder()
                    .buildOperationSourceAddress(sponsorAddress);
            if (!StringUtils.isEmpty(addSignerCertAddress)) {
                operation.buildAddSigner(addSignerCertAddress, BlockchainConstant.DEFAULT_ADMIN_WEIGHT);
            }
            if (!CollectionUtils.isEmpty(removeSignerCertAddress)) {
                for (String address : removeSignerCertAddress) {
                    operation.buildAddSigner(address, BlockchainConstant.REMOVE_SIGNER_WEIGHT);
                }
            }
            //提交交易
            operationService.newTransaction(sponsorAccount.getAddress())
                    .buildAddOperation(operation.build())
                    .buildAddSigner(sponsorAccount.getPublicKey(), sponsorAccount.getPrivateKey())
                    .commit();
            logger.info("修改签名列表（同步交易）-修改目标账户签名列表-end：targetAddress-{}, addSignerCertAddress-{} ,removeSignerCertAddress-{}",
                    sponsorAddress, addSignerCertAddress, removeSignerCertAddress);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("修改签名列表（同步交易）-修改目标账户签名列表失败：targetAddress-{}, addSignerCertAddress-{} ,removeSignerCertAddress-{}",
                    sponsorAddress, addSignerCertAddress, removeSignerCertAddress, e);
            return Boolean.FALSE;
        }
    }
}
