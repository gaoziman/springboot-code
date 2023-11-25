package org.javatop.big.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Leo
 * @date  2023-11-23 23:25
 * @version 1.0
 * @description : 用户表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
    * ID
    */
    private Integer id;

    /**
    * 用户名
    */
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{4,16}$")
    private String username;

    /**
    * 密码
    */
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{4,16}$")
    private String password;

    /**
    * 昵称
    */
    @NotEmpty
    private String nickname;

    /**
    * 邮箱
    */
    @Email
    private String email;

    /**
    * 头像
    */
    private String userPic;

    /**
    * 创建时间
    */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
    * 更新时间
    */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

}