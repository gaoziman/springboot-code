package org.javatop.big.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 23:39
 * @description :
 */
public class ResponseUtil {
    public static  void write(Result result, HttpServletResponse response) throws IOException {

        // 设置响应头
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(result));
        //关闭流
        out.close();
    }
}
