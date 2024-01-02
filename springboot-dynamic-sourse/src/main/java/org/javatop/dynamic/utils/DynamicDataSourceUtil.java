package org.javatop.dynamic.utils;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:13
 * @description : ThreadLocal工具类
 */
public class DynamicDataSourceUtil {

    private static final ThreadLocal<String> CONTEXT_HOLDER =new ThreadLocal<>();

    public static void setDataSourceType(String dsType){
        CONTEXT_HOLDER.set(dsType);
    }
    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    public static void clear(){
        CONTEXT_HOLDER.remove();
    }
}
