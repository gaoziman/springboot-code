package org.javatop.big.controller;

import org.javatop.big.pojo.User;
import org.javatop.big.service.UserService;
import org.javatop.big.utils.Result;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * @author : Leo
 * @version 1.0
 * @date Thu Nov 23 23:25:39 CST 2023
 * @description : 用户表(user)表控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(userService.selectById(id));
    }


    @PostMapping("/register")
    public Result  register(@RequestBody User user) {
        return userService.register(user);
    }


}
