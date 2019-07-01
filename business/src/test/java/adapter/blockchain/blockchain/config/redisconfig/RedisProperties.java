package adapter.blockchain.blockchain.config.redisconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/1 下午 01:49
 * @since 1.0.0
 */
@Component
@PropertySource(value= {"classpath:/application.properties"})
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private static final String PROPERTIES_FILE = "application.properties";

    /**
     * spring.redis.database=0
     * spring.redis.host=192.168.33.200
     * spring.redis.port=6379
     * spring.redis.ssl=false
     * spring.redis.password=123456
     * spring.redis.connTimeout=5000ms
     * spring.redis.maxActive=500
     * spring.redis.maxIdle=10
     * spring.redis.minIdle=0
     * spring.redis.maxWait=5000ms
     * */
    private Integer database;
    private String host;
    private Integer port;
    private Boolean ssl;
    private String password;
    private Long connTimeout;
    private Integer maxActive;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getConnTimeout() {
        return connTimeout;
    }

    public void setConnTimeout(Long connTimeout) {
        this.connTimeout = connTimeout;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }
}
