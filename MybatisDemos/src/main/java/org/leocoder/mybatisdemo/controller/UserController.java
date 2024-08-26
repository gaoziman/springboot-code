package org.leocoder.mybatisdemo.controller;

import org.leocoder.mybatisdemo.domain.User;
import org.leocoder.mybatisdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:27
 * @description :
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }


    @GetMapping("/act/{id}")
    public User getUserById3(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
}
