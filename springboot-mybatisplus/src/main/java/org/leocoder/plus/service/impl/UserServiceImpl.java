package org.leocoder.plus.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.leocoder.plus.domain.User;
import org.leocoder.plus.mapper.UserMapper;
import org.leocoder.plus.service.UserService;
/**
 * @author : Leo
 * @date  2024-07-25 09:49
 * @version 1.0
 * @description :
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
