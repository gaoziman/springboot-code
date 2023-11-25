package org.javatop.big.service;

import java.util.List;
import org.javatop.big.pojo.Article;
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

}
