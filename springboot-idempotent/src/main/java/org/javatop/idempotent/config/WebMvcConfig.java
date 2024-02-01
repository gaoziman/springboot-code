package org.javatop.idempotent.config;

import org.javatop.idempotent.interceptor.IdempotentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author : Leo
 * @version 1.0
 * @date 2024-02-01 21:21
 * @description :
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    IdempotentInterceptor idempotentInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(idempotentInterceptor).addPathPatterns("/**");
    }
}
