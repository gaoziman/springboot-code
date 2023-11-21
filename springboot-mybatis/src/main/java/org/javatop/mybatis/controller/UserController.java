package org.javatop.mybatis.controller;

import jakarta.annotation.Resource;
import org.javatop.mybatis.pojo.User;
import org.javatop.mybatis.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-02 20:12
 * @description : (test.`user`)表控制层
 */
@RestController
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
    @GetMapping("getUser/{id}")
    public User selectOne(@PathVariable Integer id) {
        return userServiceImpl.selectByPrimaryKey(id);
    }

}
