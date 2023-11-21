package org.javatop.init.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.javatop.init.pojo.User;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 15:19
 * @description :
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int updateBatchSelective(List<User> list);
}