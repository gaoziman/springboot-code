package org.javatop.idempotent.controller;

import org.javatop.idempotent.annotation.AutoIdempotent;
import org.javatop.idempotent.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-02-01 21:24
 * @description :
 */
@RestController
public class HelloController {

    @Autowired
    TokenService tokenService;

    @GetMapping("/getToken")
    public String getToken() {
        return tokenService.createToken();
    }

    @PostMapping("/hello")
    @AutoIdempotent
    public  String hello(){
        return "hello";
    }

    @PostMapping("/hello2")
    public  String hello2(){
        return "hello2222";
    }
}
