package org.javatop.big.anno;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.javatop.big.validation.StateValidation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-25 22:43
 * @description :
 */

@Documented//元注解
@Constraint(
        validatedBy = {StateValidation.class} // 提供指定规则的类
)
@Target({FIELD})//元注解
@Retention(RUNTIME)//元注解
public @interface State {

    String message() default "state的参数值只能是草稿或者已发布";

    // 指定分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
