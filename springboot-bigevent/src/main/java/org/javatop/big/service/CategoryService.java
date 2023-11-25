package org.javatop.big.service;

import java.util.List;
import org.javatop.big.pojo.Category;
import org.javatop.big.utils.Result;

/**
 * @author : Leo
 * @date  2023-11-25 13:20
 * @version 1.0
 * @description :
 */

public interface CategoryService{


    int deleteById(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectById(Integer id);

    int updateByIdSelective(Category record);

    int updateById(Category record);

    int updateBatchSelective(List<Category> list);


    /**
     * 添加分类
     * @param category 分类
     * @return 返回结果
     */
    Result insertCategory(Category category);


    /**
     * 更新文章分类
     * @param category 分类
     * @return 返回结果
     */
    Result updateCategory(Category category);


    /**
     * 获取文章分类列表
     * @return 返回结果
     */
    Result selectList();


    /**
     * 删除文章分类
     * @param id 文章分类id
     * @return 返回结果
     */
    Result delete(Integer id);
}
