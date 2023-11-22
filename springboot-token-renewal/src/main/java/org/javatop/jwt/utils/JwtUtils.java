package org.javatop.jwt.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 22:21
 * @description :
 */
public class JwtUtils {

        public static  long expire = 1000 * 60 * 5; // 毫秒单位 5分钟

        public static String secret = "Leoking";


    public static String createToken(long expire, Map map) {

        // 创建JWT构造器
        JwtBuilder builder = Jwts.builder();

        // 生成JWT字符串
        return builder
                //头部
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //载荷
                .setClaims(map)
                .setId(UUID.randomUUID().toString())
                // 签发人
                .setIssuer("Leo")
                //签发时间
                .setIssuedAt(new Date())
                //主题
                .setSubject("jwtdemo")
                //有效期
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                //自定义数据
                //签名
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }


    public static String createToken(long expire) {

        // 创建JWT构造器
        JwtBuilder builder = Jwts.builder();

        // 生成JWT字符串
        return builder
                //头部
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //载荷
                .setId(UUID.randomUUID().toString())
                // 签发人
                .setIssuer("Leo")
                //签发时间
                .setIssuedAt(new Date())
                //主题
                .setSubject("jwtdemo")
                //有效期
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                //签名
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }



    // 解析jwt
    public static String parseToken(String token) {
        return Jwts.parser()
               .setSigningKey(secret)
               .parseClaimsJws(token)
               .getBody()
               .getSubject();
    }

}
