package adapter.blockchain.blockchain.service;

import adapter.blockchain.blockchain.config.BlockChainConfig;
import cn.bubi.access.adaptation.blockchain.bc.OperationTypeV3;
import cn.bubi.access.utils.blockchain.BlockchainKeyPair;
import cn.bubi.access.utils.blockchain.SecureKeyGenerator;
import cn.bubi.sdk.core.exception.SdkException;
import cn.bubi.sdk.core.operation.impl.CreateAccountOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.transaction.Transaction;
import cn.bubi.sdk.core.transaction.model.TransactionCommittedResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/26 13:57
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {BCAutoConfiguration.class, BCAutoConfigurationSpi.class, BlockChainConfig.class})
public class _04_BlockChainOpreatorCreateSubAccount {
    @Autowired
    private BcOperationService operationService;
    @Autowired
    private BlockChainConfig blockChainConfig;

    @Test
    public void createSubAccount() {
        String realAddress = "a001f21e42e542f65a661a196e62c6eb8fdb54593c17fe";
        try {
            Transaction transaction = operationService.newTransactionByAccountPool();

            //创建payment账户
            BlockchainKeyPair payeerAccount = SecureKeyGenerator.generateBubiKeyPair();
            CreateAccountOperation groupPayOperation = new CreateAccountOperation.Builder()
                    .buildDestAddress(payeerAccount.getBubiAddress())
                    .buildPriMasterWeight(10500)
                    .buildPriTxThreshold(50)
                    .buildAddPriSigner(realAddress, 10500)
                    .buildOperationSourceAddress(blockChainConfig.getAddresss())
                    .build();

            //创建子账户
            BlockchainKeyPair subAcccount = SecureKeyGenerator.generateBubiKeyPair();
            CreateAccountOperation createSubAccountOperation = new CreateAccountOperation.Builder()
                    .buildDestAddress(subAcccount.getBubiAddress())
                    .buildPriMasterWeight(0)
                    .buildPriTxThreshold(50)
                    .buildAddPriSigner(realAddress, 10500)
                    .buildAddPriSigner(payeerAccount.getBubiAddress(), 100)
                    .buildAddPriTypeThreshold(OperationTypeV3.SET_SIGNER_WEIGHT, 10000)
                    .buildAddPriTypeThreshold(OperationTypeV3.PAYMENT, 100)
                    .buildAddPriTypeThreshold(OperationTypeV3.SET_THRESHOLD, 10000)
                    .buildOperationSourceAddress(blockChainConfig.getAddresss())
                    .build();


            TransactionCommittedResult result = transaction
                    .buildAddOperation(groupPayOperation)
                    .buildAddOperation(createSubAccountOperation)
                    .buildTxMetadata("create sub account")
                    .buildAddSigner(blockChainConfig.getPublicKey(), blockChainConfig.getPrivateKey())
                    .commit();
            System.out.println("子账户的区块链地址是：" + subAcccount.getBubiAddress() + ",payment的区块链地址是： " + payeerAccount.getBubiAddress());
            System.out.println("交易hash是： " + result.getHash());
        } catch (SdkException e) {
            e.printStackTrace();
        }
    }
}
