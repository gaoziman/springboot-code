package org.javatop.big.service;

import java.util.List;
import org.javatop.big.pojo.Article;
import org.javatop.big.pojo.model.PageBean;
import org.javatop.big.utils.Result;

/**
 * @author : Leo
 * @date  2023-11-25 15:39
 * @version 1.0
 * @description :
 */

public interface ArticleService{


    int deleteById(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectById(Integer id);

    int updateByIdSelective(Article record);

    int updateById(Article record);

    int updateBatchSelective(List<Article> list);

    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @param categoryId 分类id
     * @param state 状态
     * @return 返回结果
     */
    Result<PageBean<Article>> selectPageList(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    /**
     * 删除文章
     * @param id 文章id
     * @return 返回结果
     */
    Result delete(Integer id);


    /**
     * 添加文章
     * @param article 文章
     * @return 返回结果
     */
    Result insertArticle(Article article);


    /**
     * 更新文章
     * @param article 文章
     * @return 返回结果
     */
    Result update(Article article);

}
