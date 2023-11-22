package org.javatop.jwt.filter;

import io.jsonwebtoken.lang.Strings;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.javatop.jwt.utils.JwtUtils;
import org.javatop.jwt.utils.ResponseUtil;
import org.javatop.jwt.utils.Result;
import org.springframework.http.HttpMethod;

import java.io.IOException;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 23:31
 * @description :
 */
@WebFilter(urlPatterns = "/*")
public class JwtFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //预检
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            filterChain.doFilter(request, response);
            return;
        }
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        // 直接放行
        if (request.getRequestURI().contains("/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("token");
        if (!Strings.hasText(token)) {
            //给出错误消息提示
            Result result = new Result(500, "令牌缺失", null);
            ResponseUtil.write(result,response);
            return;
        }
        if (!JwtUtils.parseToken(token).equals("jwtdemo")) {
            //给出错误消息提示
            Result result = new Result(401, "token有误", null);
            ResponseUtil.write(result,response);
            return;
        }

            filterChain.doFilter(request, response);
    }
}
