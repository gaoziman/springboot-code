package org.javatop.big.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.javatop.big.pojo.Category;

/**
 * @author : Leo
 * @date  2023-11-25 13:20
 * @version 1.0
 * @description :
 */

@Mapper
public interface CategoryMapper {
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
    int insert(Category record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Category record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Category selectById(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByIdSelective(Category record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(Category record);

    int updateBatchSelective(List<Category> list);
}