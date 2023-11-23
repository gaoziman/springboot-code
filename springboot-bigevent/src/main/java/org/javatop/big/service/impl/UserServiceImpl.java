package org.javatop.big.service.impl;

import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.javatop.big.utils.Md5Util;
import org.javatop.big.utils.Result;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.javatop.big.mapper.UserMapper;
import org.javatop.big.pojo.User;
import org.javatop.big.service.UserService;
/**
 * @author : Leo
 * @date  2023-11-23 23:25
 * @version 1.0
 * @description :
 */

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }


    /**
     * 注册用户
     * @param user 用户信息
     * @return 返回结果
     */
    @Override
    public Result register(User user) {
        //1.查询用户
        User queryUser = userMapper.selectByUserName(user.getUsername());
        //2.判断用户是否存在
        if (ObjectUtil.isNull(queryUser)){
            // 不存在则进行注册
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            // 3.密码加密
            user.setPassword(Md5Util.getMD5String(user.getPassword()));
            user.setEmail(user.getEmail().toLowerCase());
            user.setUsername(user.getUsername().toLowerCase());
            user.setNickname(user.getNickname().toLowerCase());
            user.setUserPic("https://gaoziman.oss-cn-hangzhou.aliyuncs.com/utools-bed/14.jpg");
            userMapper.insertSelective(user);
            return Result.success();
        }else {
            return Result.error("用户已存在");
        }
    }

}
