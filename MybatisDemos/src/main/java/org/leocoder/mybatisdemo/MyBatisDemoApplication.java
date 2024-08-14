package org.leocoder.mybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:37
 * @description :
 */

@SpringBootApplication
@MapperScan("org.leocoder.mybatisdemo.mapper")
public class MyBatisDemoApplication {
    public static void main(String[] args) {
            ConfigurableApplicationContext context = SpringApplication.run(MyBatisDemoApplication.class, args);
            Environment environment = context.getBean(Environment.class);

            System.out.println("访问链接：http://localhost:" + environment.getProperty("server.port"));
            System.out.println("(♥◠‿◠)ﾉﾞ  项目启动成功 ლ(´ڡ`ლ)ﾞ \n");
        }
}
