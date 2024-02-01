package org.javatop.idempotent.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-02-01 21:03
 * @description :
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean setEx(String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断key是否存在
     * @param key key
     * @return
     */
    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 删除key
     * @param key key
     * @return
     */
    public boolean remove(String key) {
        if (exists(key)) {
            return Boolean.TRUE.equals(redisTemplate.delete(key));
        }
        return false;
    }
}
