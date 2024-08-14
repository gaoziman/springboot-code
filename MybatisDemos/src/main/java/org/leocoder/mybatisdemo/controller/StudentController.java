package org.leocoder.mybatisdemo.controller;

import org.leocoder.mybatisdemo.domain.Student;
import org.leocoder.mybatisdemo.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:29
 * @description :
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }
}
