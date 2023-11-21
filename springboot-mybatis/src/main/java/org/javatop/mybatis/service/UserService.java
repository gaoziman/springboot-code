package org.javatop.mybatis.service;

import org.javatop.mybatis.pojo.User;
    /**
 * @author : Leo
 * @date  2023-11-02 21:18
 * @version 1.0
 * @description :
 */

public interface UserService{


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
