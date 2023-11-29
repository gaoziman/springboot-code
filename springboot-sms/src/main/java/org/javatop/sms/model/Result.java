package org.javatop.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-29 20:26
 * @description : 统一结果返回类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    private Integer code;//业务状态码  0-成功  1-失败
    private String message;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(200, "success", data);
    }

    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(200, "success", null);
    }

    public static Result error(String message) {
        return new Result(500, message, null);
    }
}
