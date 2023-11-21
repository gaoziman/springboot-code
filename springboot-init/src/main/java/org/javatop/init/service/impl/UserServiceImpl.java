package org.javatop.init.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.javatop.init.pojo.User;
import org.javatop.init.mapper.UserMapper;
import org.javatop.init.service.UserService;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 15:06
 * @description :
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public int updateBatchSelective(List<User> list) {
        return baseMapper.updateBatchSelective(list);
    }
}

