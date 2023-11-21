package org.javatop.mybatis.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 15:38
 * @description :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;

    private String username;

    private Integer age;

    private String phone;

    private String email;

    private String address;

    private static final long serialVersionUID = 1L;
}