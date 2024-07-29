package org.leocoder.plus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * @author : Leo
 * @date  2024-07-25 09:49
 * @version 1.0
 * @description : 用户表
 */

@Data
@Builder
@TableName(value = "t_user")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @TableField(value = "`name`")
    private String name;


    @TableField(value = "age")
    private Integer age;


    @TableField(value = "gender")
    private Integer gender;

    private static final long serialVersionUID = 1L;
}