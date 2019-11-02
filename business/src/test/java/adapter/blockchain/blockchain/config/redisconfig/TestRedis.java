package adapter.blockchain.blockchain.config.redisconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/1 下午 01:32
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        RedisConfig.class,
        RedisProperties.class,
        RedisService.class})
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("21","12");
        redisService.set("name", "张三");
        System.out.println(redisService.get("name"));
        redisService.remove("name");
        System.out.println(redisService.get("name"));
    }


    public void getProperties() {
        redisService.set("3213", 1213, 900l);
    }
}
