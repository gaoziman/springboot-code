package org.javatop.dynamic.annotation;

import org.javatop.dynamic.constant.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:14
 * @description :  这个注解将来可以加在某一个 service 类上或者方法上，通过 value 属性来指定类或者方法应该使用哪个数据源
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DataSource{

    /**
     * 如果一个方法上加了 @DataSource 注解，但是却没有指定数据源的名称，那么默认使用 Master 数据源
     * @return
     */
    String value() default DataSourceType.default_ds_name;
}
