package org.javatop.mybatis.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import org.javatop.mybatis.mapper.UserMapper;
import org.javatop.mybatis.pojo.User;
import org.javatop.mybatis.service.UserService;
/**
 * @author : Leo
 * @date  2023-11-21 15:37
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

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }


    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }
}
