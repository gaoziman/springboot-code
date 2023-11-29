package org.javatop.sms.utils;

import cn.hutool.captcha.generator.RandomGenerator;
import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.javatop.sms.model.SmsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-29 20:34
 * @description :
 */
@Component
public class SmsUtil {

    @Autowired
    private SmsModel smsModel;


    @Autowired
    private RedisCache redisCache;


    /**
     * 生成短信验证码
     * @return
     */
    public String generateSms(String phone) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = smsModel.getAccountId();
        String accountToken = smsModel.getAuthToken();
        //请使用管理控制台中已创建应用的APPID
        String appId = smsModel.getAppId();
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String to = phone;
        String templateId= "1";
        // 使用hutool工具包生成四位随机数
        cn.hutool.captcha.generator.RandomGenerator randomGenerator = new RandomGenerator("0123456789",4);
        String randomNumber = randomGenerator.generate(); // 生成4位随机数
        Integer expire = 30; // 有效期
        String[] datas = {randomNumber,expire.toString()};
        HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas);
        if("000000".equals(result.get("statusCode"))){
            //返回生成的随机短信验证码并存入Redis中
            redisCache.setKey(phone,randomNumber,expire, TimeUnit.SECONDS);
            return randomNumber;
        }else{
            //异常返回输出错误码和错误信息
//            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return null;
        }
    }


    /**
     * 校验短信验证码
     * @param phone 手机号
     * @param code 验证码
     * @return true 校验通过 false 校验失败
     */
    public  boolean validateSms(String phone, String code) {
        String sms =  redisCache.getKey(phone);
        if (sms == null){
            throw new RuntimeException("验证码已过期");
        }
        return code.equals(sms);
    }

}
