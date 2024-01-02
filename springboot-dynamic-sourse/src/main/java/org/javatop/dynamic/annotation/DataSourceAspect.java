package org.javatop.dynamic.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.javatop.dynamic.utils.DynamicDataSourceUtil;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:15
 * @description : AOP解析自定义注解
 */
@Component
@Aspect
public class DataSourceAspect {


    /**
     * @annotation(org.javatop.dynamic.annotation.DataSource) 表示方法上有 @DataSource 注解 就将方法拦截下来。
     * @within :如果类上面有 @DataSource 注解，就将类中的方法拦截下来。
     */
    @Pointcut("@annotation(org.javatop.dynamic.annotation.DataSource) || " +
            "@within(org.javatop.dynamic.annotation.DataSource)")
    public void pc(){

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint point){
        //获取方法上面的注解
        DataSource dataSource =getDataSource(point);
        if(dataSource!=null){
            // 注解中数据源的名称
            String value = dataSource.value();
            DynamicDataSourceUtil.setDataSourceType(value);
        }
        try {
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            DynamicDataSourceUtil.clear();
        }
        return null;
    }

    private DataSource getDataSource(ProceedingJoinPoint point) {
        /**
         * 先去查找方法上的注解，如果没有，再去类中找。
         */
        MethodSignature signature = (MethodSignature)point.getSignature();
        DataSource annotation = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if(annotation!=null){
            return annotation;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(),DataSource.class);
    }
}
