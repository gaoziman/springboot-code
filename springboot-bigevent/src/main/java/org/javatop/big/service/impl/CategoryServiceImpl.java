package org.javatop.big.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.javatop.big.mapper.CategoryMapper;
import org.javatop.big.pojo.Category;
import org.javatop.big.service.CategoryService;
/**
 * @author : Leo
 * @date  2023-11-25 13:00
 * @version 1.0
 * @description :
 */

@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public int deleteById(Integer id) {
        return categoryMapper.deleteById(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public int updateByIdSelective(Category record) {
        return categoryMapper.updateByIdSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatchSelective(List<Category> list) {
        return categoryMapper.updateBatchSelective(list);
    }

}
