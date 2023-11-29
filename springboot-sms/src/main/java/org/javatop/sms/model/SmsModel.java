package org.javatop.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-29 20:26
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties("javatop.sms")
public class SmsModel {


    /* 账户ID */
    private String accountId;

    /* 账户密钥 */
    private String authToken;

    /* 应用ID */
    private String appId;
}
