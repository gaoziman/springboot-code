package org.javatop.big.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javatop.big.pojo.Article;

/**
 * @author : Leo
 * @date  2023-11-25 15:39
 * @version 1.0
 * @description :
 */

@Mapper
public interface ArticleMapper {
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
    int insert(Article record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Article record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Article selectById(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByIdSelective(Article record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(Article record);

    int updateBatchSelective(List<Article> list);


    /**
     * 根据分类id和状态查询文章
     * @param categoryId 分类id
     * @param state 状态
     * @return 返回结果
     */
    List<Article> selectAllByCategoryIdAndState(@Param("categoryId")Integer categoryId, @Param("state")String state, @Param("createUser") Integer createUser);



    Article selectByCreateUserAndId(@Param("createUser") Integer createUser,@Param("id")Integer id);







}