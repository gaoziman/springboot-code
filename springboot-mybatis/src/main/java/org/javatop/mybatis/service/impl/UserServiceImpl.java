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
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
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
    public int updateByIdSelective(User record) {
        return userMapper.updateByIdSelective(record);
    }

    @Override
    public int updateById(User record) {
        return userMapper.updateById(record);
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
