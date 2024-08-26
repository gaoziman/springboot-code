package org.leocoder.mybatisdemo.enums;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-26 15:12
 * @description :
 */
public enum DesensitizationTypeEnum {
    // 自定义
    MY_RULE {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return StrUtil.hide(str, startInclude, endExclude);
        }
    },
    // 用户id脱敏
    USER_ID {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return String.valueOf(DesensitizedUtil.userId());
        }
    },
    // 手机号脱敏
    PHONE {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return String.valueOf(DesensitizedUtil.mobilePhone(str));
        }
    },
    // 邮箱脱敏
    EMAIL {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return String.valueOf(DesensitizedUtil.email(str));
        }
    };

    public abstract String desensitize(String str, Integer startInclude, Integer endExclude);
}
