package org.javatop.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 22:34
 * @description :
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "org.javatop.jwt")
public class SpringBootTokenRenewalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTokenRenewalApplication.class, args);
        Environment environment = context.getBean(Environment.class);

        System.out.println("访问链接：http://localhost:" + environment.getProperty("server.port"));
        System.out.println("(♥◠‿◠)ﾉﾞ  项目启动成功 ლ(´ڡ`ლ)ﾞ \n");
    }
}
