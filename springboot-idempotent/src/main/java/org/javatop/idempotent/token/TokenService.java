package org.javatop.idempotent.token;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.javatop.idempotent.exception.IdempotentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-02-01 21:01
 * @description :
 */
@Component
public class TokenService {

    @Autowired
    RedisService redisService;

    public String createToken() {
        String uuid = UUID.randomUUID().toString();
        redisService.setEx(uuid, uuid, 10000L);
        return uuid;
    }

    public boolean checkToken(HttpServletRequest request) throws IdempotentException {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
            if (StringUtils.isEmpty(token)) {
                throw new IdempotentException("token 不存在");
            }
        }
        if (!redisService.exists(token)) {
            throw new IdempotentException("重复的操作");
        }
        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new IdempotentException("重复的操作");
        }
        return true;
    }
}
