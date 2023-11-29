package org.javatop.sms.controller;

import org.javatop.sms.model.Result;
import org.javatop.sms.model.SmsModel;
import org.javatop.sms.utils.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-29 20:46
 * @description :
 */
@RestController
@CrossOrigin
public class SmsController {

    @Autowired
    private SmsUtil smsUtil;

    @PostMapping("/send")
    public Result sendSms(@RequestBody Map<String,String> map) {
        if (map.get("phone") == null) {
            return Result.error("手机号不能为空");
        }

        String str = map.get("phone");
        String sms = smsUtil.generateSms(str);
        if (sms.length() == 4){
            return Result.success(sms);
        }
        return Result.error("短信验证码发送失败");
    }


    @PostMapping("/validate")
    public Result validateSms(@RequestBody Map<String,String> map) {
        if (map.get("phone") == null) {
            return Result.error("手机号不能为空");
        }
        if (map.get("code") == null) {
            return Result.error("验证码不能为空");
        }
        String str = map.get("phone");
        String code = map.get("code");
        boolean flag = smsUtil.validateSms(str, code);
        if (flag) {
            return Result.success();
        } else {
            return Result.error("验证码错误");
        }
    }
}
