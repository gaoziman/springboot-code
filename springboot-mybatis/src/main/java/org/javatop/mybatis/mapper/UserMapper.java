package org.javatop.mybatis.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.javatop.mybatis.pojo.User;

/**
 * @author : Leo
 * @date  2023-11-21 15:38
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


    User selectByPhone(@Param("phone")String phone);



}