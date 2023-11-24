package org.javatop.big.controller;

import org.javatop.big.pojo.User;
import org.javatop.big.pojo.vo.UserVo;
import org.javatop.big.service.UserService;
import org.javatop.big.utils.BeanUtils;
import org.javatop.big.utils.JwtUtil;
import org.javatop.big.utils.Result;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

import java.util.Map;

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


    /**
     * 注册用户
     *
     * @param user 用户信息
     * @return 返回结果
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回结果
     */
    @PostMapping("/login")
    public Result login(String username, String password) {
        return userService.login(username, password);
    }


    /**
     * 获取用户详细信息
     * @param token token
     * @return 返回结果
     */
    @GetMapping("/userInfo")
    public Result userInfo(@RequestHeader("Authorization") String token) {
        // 解析token
        Map<String, Object> map = JwtUtil.parseToken(token);
        Integer id = (Integer) map.get("id");
        // 查询用户
        User user = userService.selectById(id);
        //拷贝对象
        UserVo userVo = BeanUtils.copyBean(user, UserVo.class);
        return Result.success(userVo);
    }


    /**
     * 更新用户基本信息
     * @param user 用户信息
     * @return 返回结果
     */
    @PutMapping("/update")
    public Result update(@RequestHeader("Authorization") String token,@RequestBody User user) {
        return userService.updateInfo(token,user);
    }


}
