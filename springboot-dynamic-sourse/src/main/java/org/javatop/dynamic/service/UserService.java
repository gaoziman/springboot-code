package org.javatop.dynamic.service;

import org.javatop.dynamic.annotation.DataSource;
import org.javatop.dynamic.domain.User;
import org.javatop.dynamic.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:26
 * @description :
 */
@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    @DataSource("slave")
//    @DataSource
    public List<User> getAll(){
        List<User> all = userMapper.getAll();
        return all;
    }
}
