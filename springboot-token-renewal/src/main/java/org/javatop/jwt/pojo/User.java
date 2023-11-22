package org.javatop.jwt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 22:52
 * @description :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    /*用户id*/
    private Integer id;

    /*用户名*/
    private String username;

    /*密码*/
    private String password;
}
