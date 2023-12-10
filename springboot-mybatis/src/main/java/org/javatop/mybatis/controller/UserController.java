package org.javatop.mybatis.controller;

import org.javatop.mybatis.pojo.User;
import org.javatop.mybatis.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * @author : Leo
 * @version 1.0
 * @date Tue Nov 21 15:37:39 CST 2023
 * @description : (user)表控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userServiceImpl.selectById(id);
    }


    /**
     * 通过手机号查找用户
     *
     * @param phone 手机号
     * @return 用户
     */
    @GetMapping("/phone/{phone}")
    public User getByPhone(@PathVariable String phone) {
        return userServiceImpl.selectByPhone(phone);
    }

}
