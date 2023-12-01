import org.javatop.big.BigEventApplication;
import org.javatop.big.utils.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-26 1:35
 * @description :
 */
@SpringBootTest(classes = {BigEventApplication.class})
public class RedisTest {
    @Autowired
    private RedisCache redisCache;

    /**
     * 用于测试: redis
     */
    @Test
    public void testRedis() {
        redisCache.setKey("age","20", 10, TimeUnit.SECONDS);
        String name =  redisCache.getKey("name");
        System.out.println("name = " + name);
        redisCache.deleteObject("年龄");
    }
}
