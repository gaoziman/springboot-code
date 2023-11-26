package org.javatop.big.service;

import java.util.List;
import java.util.Map;

import org.javatop.big.pojo.User;
import org.javatop.big.utils.Result;

/**
 * @author : Leo
 * @date  2023-11-23 23:25
 * @version 1.0
 * @description :
 */

public interface UserService{


    int deleteById(Integer id);

    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户
     */
    User selectById(Integer id);

    int updateByIdSelective(User record);

    int updateById(User record);

    int updateBatchSelective(List<User> list);


    /**
     * 用户注册
     * @param user 用户信息
     * @return 返回结果
     */
     Result register(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 返回结果
     */
     Result login(String username, String password);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 返回结果
     */
    Result updateInfo( User user);


    /**
     * 更新用户头像
     * @param url 头像地址
     * @return 返回结果
     */
    Result updateAvatar(String url);

    Result updatePwd(Map<String, String> map,String token);
}
