package org.javatop.jwt.controller;

import org.javatop.jwt.pojo.User;
import org.javatop.jwt.utils.JwtUtils;
import org.javatop.jwt.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 22:54
 * @description :
 */
@RestController
@CrossOrigin
public class LoginController {


    @PostMapping("/login")
    public Result login(@RequestBody User user){
        int code = 200;
        String msg = "success";
        Map<String, Object> map = new HashMap<>();
        String accessToken = null;
        String refreshToken = null;
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            accessToken  = JwtUtils.createToken(1000 * 10); // 10秒
            refreshToken = JwtUtils.createToken(1000 * 20); // 20秒
            map.put("accessToken",accessToken);
            map.put("refreshToken",refreshToken);
        }else{
            code = 201;
            msg = "用户名或密码错误";
        }
        return new Result(code,msg,map);
    }
}
