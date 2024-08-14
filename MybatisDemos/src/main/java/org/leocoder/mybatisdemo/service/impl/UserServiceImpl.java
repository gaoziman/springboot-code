package org.leocoder.mybatisdemo.service.impl;

import org.leocoder.mybatisdemo.domain.User;
import org.leocoder.mybatisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:28
 * @description :
 */

@Service
public class UserServiceImpl{

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.selectUserById2(id);
    }


}
