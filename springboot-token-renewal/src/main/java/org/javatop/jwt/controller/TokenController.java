package org.javatop.jwt.controller;

import org.javatop.jwt.utils.JwtUtils;
import org.javatop.jwt.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-22 19:30
 * @description :
 */
@RestController
@CrossOrigin
public class TokenController {


    @GetMapping("/newToken")
    public Result newToken() {
        Map map = new HashMap();
        String  accessToken  = JwtUtils.createToken(1000 * 10); // 10秒
        String  refreshToken = JwtUtils.createToken(1000 * 20); // 20秒
        map.put("accessToken",accessToken);
        map.put("refreshToken",refreshToken);
        return new Result(200,"success",map);
    }
}
