package org.javatop.service.impl;

import jakarta.annotation.Resource;
import org.javatop.mybatis.mapper.UserMapper;
import org.javatop.mybatis.pojo.User;
import org.javatop.mybatis.service.UserService;
import org.springframework.stereotype.Service;
/**
 * @author : Leo
 * @date  2023-11-02 21:18
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
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
