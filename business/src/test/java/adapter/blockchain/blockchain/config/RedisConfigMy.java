package adapter.blockchain.blockchain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.jcache.config.JCacheConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/24 13:19
 * @since 1.0.0
 */
//@Configuration
//@PropertySource("classpath:application.properties")
public class RedisConfigMy extends JCacheConfigurerSupport {
    @Autowired
    private Environment environment;

    @Bean
    // 初始化连接
    public RedisStandaloneConfiguration redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();

        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();

        redisStandaloneConfiguration.setHostName(environment.getProperty("redis.hostName"));
        redisStandaloneConfiguration.setPort(Integer.parseInt(environment.getProperty("redis.port")));
        redisStandaloneConfiguration.setPassword(environment.getProperty("redis.password"));
        return redisStandaloneConfiguration;
    }

 /*   @Bean
    //配置缓存
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.create(connectionFactory);
    }*/

  /*  @Bean
    //
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redis = new RedisTemplate<>();
        redis.setConnectionFactory(redisConnectionFactory);
        redis.afterPropertiesSet();
        return redis;
    }*/

    /**
     * 连接池配置信息
     */

   /* @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(100);
        //最小空闲连接数
        jedisPoolConfig.setMinIdle(20);
        //当池内没有可用连接时，最大等待时间
        jedisPoolConfig.setMaxWaitMillis(10000);
        //其他属性可以自行添加
        return jedisPoolConfig;
    }*/

    /**
     * jedis连接工厂
     *
     * @param jedisPoolConfig
     * @return
     */
   /* @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        //设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        //获得默认的连接池构造
        //这里需要注意的是，edisConnectionFactoryJ对于Standalone模式的没有（RedisStandaloneConfiguration，JedisPoolConfig）的构造函数，对此
        //我们用JedisClientConfiguration接口的builder方法实例化一个构造器，还得类型转换
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //修改我们的连接池配置
        jpcf.poolConfig(jedisPoolConfig);
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();

        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }*/

}
