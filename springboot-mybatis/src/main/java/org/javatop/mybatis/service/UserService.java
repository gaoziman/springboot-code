package org.javatop.mybatis.service;

import java.util.List;
import org.javatop.mybatis.pojo.User;
    /**
 * @author : Leo
 * @date  2023-11-21 15:37
 * @version 1.0
 * @description :
 */

public interface UserService{


    int deleteById(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectById(Integer id);

    int updateByIdSelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatchSelective(List<User> list);

        User selectByPhone(String phone);
    }
