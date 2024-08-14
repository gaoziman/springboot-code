package org.leocoder.mybatisdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:24
 * @description :
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;


    // 一对一
    private Address address;


    // 一对多
    private List<Order> orders;

}
