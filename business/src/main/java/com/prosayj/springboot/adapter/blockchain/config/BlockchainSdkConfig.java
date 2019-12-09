

package com.prosayj.springboot.adapter.blockchain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("bunuo.bcsdk")
public class BlockchainSdkConfig {
    /**
     * 默认每一个交易等待的区块链偏移量：1个区块偏移量=3秒或1分钟，可以用3s进行推断，最快情况1分钟=20个区块偏移量
     */
    private int defaultFinalNotifySeqOffset;
    /**
     * 默认交易队列的缓存个数，单位千
     */
    private int defaultTransactionQueueLength;

    public int getDefaultFinalNotifySeqOffset() {
        return defaultFinalNotifySeqOffset;
    }

    public void setDefaultFinalNotifySeqOffset(int defaultFinalNotifySeqOffset) {
        this.defaultFinalNotifySeqOffset = defaultFinalNotifySeqOffset;
    }

    public int getDefaultTransactionQueueLength() {
        return defaultTransactionQueueLength;
    }

    public void setDefaultTransactionQueueLength(int defaultTransactionQueueLength) {
        this.defaultTransactionQueueLength = defaultTransactionQueueLength;
    }
}
