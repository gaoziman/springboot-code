package org.javatop.big.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.google.common.base.Strings;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.javatop.big.utils.JwtUtil;
import org.javatop.big.utils.ResponseUtil;
import org.javatop.big.utils.Result;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-24 13:36
 * @description :
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (ObjectUtil.isNull(token)) {
            //给出错误消息提示
            Result result = new Result(500, "令牌缺失", null);
            ResponseUtil.write(result,response);
        }
        try {
            // 验证token
            Map<String, Object> map = JwtUtil.parseToken(token);
            return true;
        } catch (Exception e) {
            //给出错误信息
            Result result = new Result(401, "令牌失效", null);
            ResponseUtil.write(result,response);
            return false;
        }
    }
}
