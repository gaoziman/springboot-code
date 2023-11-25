package org.javatop.big.service.impl;

import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.javatop.big.utils.Result;
import org.javatop.big.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javatop.big.mapper.CategoryMapper;
import org.javatop.big.pojo.Category;
import org.javatop.big.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Leo
 * @date  2023-11-25 13:20
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
    public int updateById(Category record) {
        return categoryMapper.updateById(record);
    }

    @Override
    public int updateBatchSelective(List<Category> list) {
        return categoryMapper.updateBatchSelective(list);
    }





    /**
     * 添加分类
     * @param category 分类
     * @return 返回结果
     */
    @Override
    public Result insertCategory(Category category) {
        if (ObjectUtil.isNotNull(category)) {
            Map map = ThreadLocalUtil.get();
            Integer id = (Integer) map.get("id");
            category.setCreateTime(new Date());
            category.setUpdateTime(new Date());
            category.setCreateUser(id);
            int i = categoryMapper.insert(category);
            if (i > 0) {
                return Result.success("文章新增成功!!!");
            } else {
                return Result.error("文章新增失败!!!");
            }
        }
        return Result.error("文章分类不能为空!!!");
    }



    /**
     * 更新文章分类
     * @param category 分类
     * @return 返回结果
     */
    @Override
    public Result updateCategory(Category category) {
        if (ObjectUtil.isNotNull(category)) {
            Map map = ThreadLocalUtil.get();
            Integer id = (Integer) map.get("id");
            Category queryCategory = categoryMapper.selectByCreateUserAndId(id, category.getId());
            if (ObjectUtil.isNotNull(queryCategory)){
                category.setUpdateTime(new Date());
                int i = categoryMapper.updateByIdSelective(category);
                if (i > 0) {
                    return Result.success("文章更新成功!!!");
                } else {
                    return Result.error("文章更新失败!!!");
                }
            }else {
                return Result.error("不能对此分类进行更新操作!!!");
            }

        }
        return Result.error("文章分类不能为空!!!");
    }



    /**
     * 获取文章分类列表
     * @return 返回结果
     */
    @Override
    public Result selectList() {
        Map map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        Category category = new Category();
        category.setCreateUser(userId);
        return Result.success(categoryMapper.selectListByCondition(category));
    }


    /**
     * 删除文章分类
     * @param id 文章分类id
     * @return 返回结果
     */
    @Override
    public Result delete(Integer id) {
            Map map = ThreadLocalUtil.get();
            Integer userId = (Integer) map.get("id");
            Category queryCategory = categoryMapper.selectByCreateUserAndId(userId,id);
            if (ObjectUtil.isNotNull(queryCategory)){
                int i = categoryMapper.deleteById(id);
                if (i > 0) {
                    return Result.success("文章删除成功!!!");
                } else {
                    return Result.error("文章删除失败!!!");
                }
            }else {
                return Result.error("不能对此分类进行删除操作!!!");
            }

    }
}
