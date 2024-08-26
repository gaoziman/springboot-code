package org.leocoder.mybatisdemo.config;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.leocoder.mybatisdemo.annotation.Desensitization;
import org.leocoder.mybatisdemo.enums.DesensitizationTypeEnum;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-26 15:13
 * @description : 自定义序列化类，用于数据脱敏处理。 支持多种脱敏类型，包括自定义规则。
 *
 */
@AllArgsConstructor
@NoArgsConstructor
public class DesensitizationSerialize extends JsonSerializer<String> implements ContextualSerializer {
    private DesensitizationTypeEnum type;
    private Integer startInclude;
    private Integer endExclude;

    @Override
    public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(type.desensitize(str, startInclude, endExclude));
    }


    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            // 判断数据类型是否为String类型
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                // 获取定义的注解
                Desensitization desensitization = beanProperty.getAnnotation(Desensitization.class);
                // 如果字段上没有注解，则从上下文中获取注解
                if (desensitization == null) {
                    desensitization = beanProperty.getContextAnnotation(Desensitization.class);
                }
                // 如果找到了注解，创建新的序列化实例
                if (desensitization != null) {
                    return new DesensitizationSerialize(desensitization.type(), desensitization.startInclude(), desensitization.endExclude());
                }
            }
            // 如果不是String类型，使用默认的序列化处理
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        // 如果beanProperty为null，返回默认的null值序列化处理
        return serializerProvider.findNullValueSerializer(null);
    }
}
