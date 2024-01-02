package org.javatop.dynamic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.javatop.dynamic.domain.User;

import java.util.List;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-01-02 15:26
 * @description :
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();
}
