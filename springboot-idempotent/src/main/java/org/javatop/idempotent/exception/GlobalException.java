package org.javatop.idempotent.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IdempotentException.class)
    public String idempotentException(IdempotentException e) {
        return e.getMessage();
    }
}
