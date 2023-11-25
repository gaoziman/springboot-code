package org.javatop.big.service;

import java.util.List;
import org.javatop.big.pojo.Category;
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

}
