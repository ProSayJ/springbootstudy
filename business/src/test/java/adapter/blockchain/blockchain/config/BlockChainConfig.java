package adapter.blockchain.blockchain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("blockchain.recommender")
@PropertySource("classpath:application.properties")
public class BlockChainConfig {
    /**
     * 是否使用区块链记账
     */
    private boolean isuse;
    /**
     * 账户地址
     */
    private String addresss;
    /**
     * 账户私钥
     */
    private String privateKey;

    /**
     * 账户公钥
     */
    private String publicKey;
    /**
     * 区块偏移量
     */
    private int offset;

    /**
     * 是否使用区块链记账
     */
    public boolean isIsuse() {
        return isuse;
    }

    /**
     * 是否使用区块链记账
     */
    public void setIsuse(boolean isuse) {
        this.isuse = isuse;
    }

    /**
     * 账户地址
     */
    public String getAddresss() {
        return addresss;
    }

    /**
     * 账户地址
     */
    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    /**
     * 账户私钥
     */
    public String getPrivateKey() {
        return privateKey;
    }

    /**
     * 账户私钥
     */
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * 账户公钥
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * 账户公钥
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * 区块偏移量
     */
    public int getOffset() {
        return offset;
    }

    /**
     * 区块偏移量
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

}
