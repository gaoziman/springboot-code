package org.javatop.jwt.controller;

import org.javatop.jwt.pojo.User;
import org.javatop.jwt.utils.JwtUtils;
import org.javatop.jwt.utils.Result;
import org.springframework.web.bind.annotation.*;

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
        Integer code = 200;
        String msg = "success";
        String token = null;
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")){
                token = JwtUtils.createToken(1000*60);
        }else{
            code = 201;
            msg = "用户名或密码错误";
        }

        return new Result(code,msg,token);
    }
}
