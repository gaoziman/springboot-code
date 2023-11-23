package org.javatop.big.service;

import java.util.List;
import org.javatop.big.pojo.User;
import org.javatop.big.utils.Result;

/**
 * @author : Leo
 * @date  2023-11-23 23:25
 * @version 1.0
 * @description :
 */

public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户
     */
    User selectById(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatchSelective(List<User> list);

     Result register(User user);
    }
