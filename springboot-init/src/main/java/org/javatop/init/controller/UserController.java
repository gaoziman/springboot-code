package org.javatop.init.controller;

import org.javatop.init.pojo.User;
import org.javatop.init.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 15:19
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
        return userServiceImpl.getById(id);
    }


    @GetMapping("/all")
    public List<User> getAll() {
        return userServiceImpl.list();
    }

}
