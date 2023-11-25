package org.javatop.big.exception;

import org.javatop.big.utils.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-25 15:05
 * @description :
 */
@RestControllerAdvice
public class BusinessException {


    /**
     * 自定义全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}
