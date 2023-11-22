package org.javatop.jwt.utils;

import lombok.Data;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 23:08
 * @description :
 */
@Data
public class Result{
    private int code;
    private String msg;
    private Object data;



    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
