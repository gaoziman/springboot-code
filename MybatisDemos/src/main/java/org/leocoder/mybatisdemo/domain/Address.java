package org.leocoder.mybatisdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:24
 * @description :
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private Integer id;
    private String street;
    private String city;
    private Integer userId;

}
