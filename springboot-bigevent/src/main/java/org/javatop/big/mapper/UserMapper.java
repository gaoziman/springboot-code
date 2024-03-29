package org.javatop.big.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.javatop.big.pojo.User;
import org.javatop.big.utils.Result;

/**
 * @author : Leo
 * @date  2023-11-23 23:25
 * @version 1.0
 * @description :
 */

@Mapper
public interface UserMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteById(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(User record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    User selectById(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByIdSelective(User record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(User record);

    int updateBatchSelective(List<User> list);


    User selectByUserName(@Param("username")String username);


    /**
     * 更新用户头像
     *
     * @param url 头像地址
     * @return 受影响行数
     */
    int updateUserPicById(@Param("userPic")String url,@Param("id")Integer id);


    int updatePasswordById(@Param("password")String password,@Param("id")Integer id);


}