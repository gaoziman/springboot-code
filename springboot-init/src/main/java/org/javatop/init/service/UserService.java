package org.javatop.init.service;

import org.javatop.init.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 15:06
 * @description :
 */

public interface UserService extends IService<User> {


    int updateBatchSelective(List<User> list);
}

