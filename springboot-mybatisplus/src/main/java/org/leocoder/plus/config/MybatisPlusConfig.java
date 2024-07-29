package org.leocoder.plus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-07-25 09:37
 * @description :
 */
@Configuration
@MapperScan("org.leocoder.plus.mapper")
public class MybatisPlusConfig {
}