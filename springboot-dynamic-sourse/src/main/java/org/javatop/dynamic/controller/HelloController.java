package org.javatop.dynamic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 11:51
 * @description : Hello测试接口
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String say(){
        return "Hello World!";
    }
}
