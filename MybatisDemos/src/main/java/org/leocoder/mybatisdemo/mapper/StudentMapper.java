package org.leocoder.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.leocoder.mybatisdemo.domain.Student;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:34
 * @description :
 */

@Mapper
public interface StudentMapper {
    Student selectStudentById(Integer id);
}
