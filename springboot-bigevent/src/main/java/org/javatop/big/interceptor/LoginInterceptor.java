package org.javatop.big.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.base.Strings;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.javatop.big.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.Objects;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-24 13:36
 * @description :
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisCache redisCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            if (ObjectUtil.isNull(redisCache.getKey(token))) {
               throw  new RuntimeException();
            }
            // 验证token
            Map<String, Object> map = JwtUtil.parseToken(token);
            // 把信息存入ThreadLocal
            // 判断redis中的token和header中的token是否一致
            ThreadLocalUtil.set(map);
            return true;
        } catch (Exception e) {
            //给出错误信息
            Result result = new Result(401, "令牌失效", null);
            ResponseUtil.write(result,response);
            return false;
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        ThreadLocalUtil.remove();
    }
}
