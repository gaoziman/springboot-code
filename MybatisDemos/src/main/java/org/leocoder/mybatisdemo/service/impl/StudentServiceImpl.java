package org.leocoder.mybatisdemo.service.impl;

import org.leocoder.mybatisdemo.domain.Student;
import org.leocoder.mybatisdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:29
 * @description :
 */

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }
}
