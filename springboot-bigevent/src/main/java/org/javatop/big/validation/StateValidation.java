package org.javatop.big.validation;

import cn.hutool.core.util.ObjectUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.javatop.big.anno.State;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-25 22:52
 * @description :
 */
public class StateValidation implements ConstraintValidator<State,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 提供校验规则
        if (ObjectUtil.isNull(value)){
            return false;
        }
        if (value.equals("已发布") || value.equals("草稿")){
            return true;
        }
        return false;
    }
}
