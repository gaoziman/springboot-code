package org.leocoder.mybatisdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:25
 * @description :
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;
    private String name;

    // 多对多关系
    private List<Course> courses;

}
