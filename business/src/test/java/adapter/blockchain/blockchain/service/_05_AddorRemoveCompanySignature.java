package adapter.blockchain.blockchain.service;

import cn.bubi.sdk.core.operation.impl.SetSignerWeightOperation;
import cn.bubi.sdk.core.spi.BcOperationService;
import com.prosayj.springboot.adapter.blockchain.constant.BlockchainConstant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/16 上午 10:22
 * @since 1.0.0
 */
public class _05_AddorRemoveCompanySignature {
    @Autowired
    private BcOperationService operationService;

    @Test
    public void addorRemoveCompanySignature() {
        String publicKey = "b00102e48ef824231a13593a884ab3ba839266eeb2f398fb4a50cac3c6e89866ab62a5";
        String privateKey = "c001970cc4c8d56511e73a1de352b82ce3ccf11ca7fa8d9dd8c2e3716c617f138c5aa8";
        String sponsorAccountAddress = "a0019c03e701afbc60be8eafc7c798b31b0dc27b34f365";
        List<String> removeSignerCertAddress = Arrays.asList("a00447ff10309c24667d007df68728a239a3e781f78fa8");
        try {
            //组装操作
            SetSignerWeightOperation.Builder operation = new SetSignerWeightOperation
                    .Builder()
                    .buildOperationSourceAddress(sponsorAccountAddress);
            for (String address : removeSignerCertAddress) {
                operation.buildAddSigner(address, BlockchainConstant.DEFAULT_ADMIN_WEIGHT);
            }
            //提交交易
            operationService.newTransaction(sponsorAccountAddress)
                    .buildAddOperation(operation.build())
                    .buildAddSigner(publicKey, privateKey)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
