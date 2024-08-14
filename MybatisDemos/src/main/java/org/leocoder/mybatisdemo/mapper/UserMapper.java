package org.leocoder.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
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
}
