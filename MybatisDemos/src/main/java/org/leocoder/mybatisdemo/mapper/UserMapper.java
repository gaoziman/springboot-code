package org.leocoder.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.leocoder.mybatisdemo.domain.User;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-14 14:28
 * @description :
 */

@Mapper
public interface UserMapper {


    User selectUserById(Integer id);

    User selectUserById2(Integer id);


    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserById3(Integer id);
}
