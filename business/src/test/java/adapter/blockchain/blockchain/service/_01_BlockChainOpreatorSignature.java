package adapter.blockchain.blockchain.service;

import adapter.blockchain.blockchain.config.RedisConfigMy;
import cn.bubi.access.starter.BCAutoConfiguration;
import cn.bubi.access.starter.BCAutoConfigurationSpi;
import cn.bubi.sdk.core.operation.OperationFactory;
import cn.bubi.sdk.core.operation.impl.SetSignerWeightOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import cn.bubi.sdk.core.transaction.Transaction;
import cn.bubi.sdk.core.transaction.model.TransactionBlob;
import cn.bubi.sdk.core.utils.SerializeUtil;
import com.prosayj.springboot.utils.security.EncodeConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangjian
 * @description 区块链操作_签名列表
 * <p>
 * 1 CREATE_ACCOUNT 创建账号
 * 2 ISSUE_ASSET 发行资产
 * 3 PAYMENT 转移资产
 * 4 SET_METADATA 设置metadata
 * 5 SET_SIGNER_WEIGHT 设置权重
 * 6 SET_THRESHOLD 设置门限
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/24 16:00
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BCAutoConfiguration.class, BCAutoConfigurationSpi.class, RedisConfigMy.class})
public class _01_BlockChainOpreatorSignature {
    @Autowired
    private BcOperationService operationService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 为目标账户的签名列表添加一个地址，并设置权重
     * 方式一：自己操作自己账户的签名列表：这里不需要获取blob签名
     * 前提：
     * 1：自己的公私钥对
     * master_weight >=tx_threshold
     * master_weight > = threshold(type= 是操作签名列表的操作的个性化设置，如果没有设置，则大于基础门限即可)
     */
    @Test
    public void addSignerAndSetWeight() {
        //待操作的目标账户：
        String targetAddress = "a0014eb691dc24616227264287dc23f0f830f9002b1f32";
        //待添加到目标账户签名列表的区块链地址_必须是有效的
        String signerAddress = "a001f7751ccdba81d09fcea37ec1b43b9a910ae3112842";
        //待添加到目标账户签名列表的地址对应的权重
        Integer weight = 1;

        //操作人地址_自己
        String sponsorAddress = "a0014eb691dc24616227264287dc23f0f830f9002b1f32";
        //操作人公钥_自己
        String sponsorPublicKey = "b00125d53002bfd35b20fec0c8c69ef2dbeaa79398db808a8473928ae773a541c93b34";
        //操作人私钥_自己
        String sponsorPrivateKey = "c001e8bb8956d37ab1cec25e421876b352d62f50250bc9da111ffc4464e132728555ba";

        try {
            //组装操作
            SetSignerWeightOperation.Builder operation = new SetSignerWeightOperation
                    .Builder()
                    .buildOperationSourceAddress(targetAddress)//操作目标账户
                    .buildAddSigner(signerAddress, weight);
            //提交交易
            SetSignerWeightOperation build = operation.build();

            operationService.newTransaction(targetAddress)//目标账户
                    .buildAddOperation(build)
                    .buildAddSigner(sponsorPublicKey, sponsorPrivateKey)//操作人
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 为目标账户的签名列表添加一个地址，并设置权重
     * 方式二：他人操作目标账户的签名列表：这里不需要获取blob签名：即他人的签名
     * 前提：
     * 1：他人的某种签名方式：
     * 他人的地址需要存在于目标账户的签名列表里面
     * 且签名列表里面的权重 >=  >=tx_threshold
     * 签名列表里面的权重 > = threshold(type= 是操作签名列表的操作的个性化设置，如果没有设置，则大于基础门限即可)
     */
    @Test
    public void addSignerAndSetWeight02() {
        //待操作的目标账户：
        String targetAddress = "a0014eb691dc24616227264287dc23f0f830f9002b1f32";
        //待添加到目标账户签名列表的区块链地址_必须是有效的
        String signerAddress = "a001f7751ccdba81d09fcea37ec1b43b9a910ae3112842";
        //待添加到目标账户签名列表的地址对应的权重
        Integer weight = 55;
        try {
            //新建一个交易_目标账户的签名列表添加一个地址，并设置权重
            Transaction transaction = operationService
                    .newTransaction(targetAddress)
                    .buildAddOperation(OperationFactory.newSetSignerWeightOperation(signerAddress, weight));
            //获取交易的blob
            TransactionBlob transactionBlob = transaction
                    //默认每一个交易等待的区块链偏移量：1个区块偏移量=3秒或1分钟，可以用3s进行推断，最快情况1分钟=20个区块偏移量
                    .buildFinalNotifySeqOffset(100)
                    .generateBlob();

            String hash = transactionBlob.getHash();
            String blob = EncodeConverter.hex2Base64(transactionBlob.getHex());
            //暂存transaction，签名后提交
//            TransactionContent.put(hash, transaction);
            redisTemplate.opsForValue().set(hash, SerializeUtil.serialize(transaction.forSerializable()));

            System.out.println("发起交易之前获取获取交易的hash：" + hash);
            System.out.println("发起交易之前获取获取交易的blob：" + blob);
            //前端用私钥签名blob，提交公钥和签名结果。
            //前端拿到hash提交
//            submitTrans();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
