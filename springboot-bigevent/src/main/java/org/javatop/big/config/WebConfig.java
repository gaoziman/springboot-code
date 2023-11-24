package org.javatop.big.config;

import org.javatop.big.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-24 13:48
 * @description :
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private  LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
    }
}
