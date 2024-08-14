package org.leocoder.mybatisdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:24
 * @description :
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Integer id;
    private Date orderDate;
    private Integer userId;
}
