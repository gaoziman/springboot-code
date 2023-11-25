package org.javatop.big.controller;
import org.javatop.big.pojo.Category;
import org.javatop.big.service.CategoryService;
import org.javatop.big.service.impl.CategoryServiceImpl;
import org.javatop.big.utils.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
* @author : Leo
* @date  Sat Nov 25 13:20:31 CST 2023
* @version 1.0
* @description : (category)表控制层
*/
@RestController
@RequestMapping("/category")
public class CategoryController {
 
    @Resource
    private CategoryService categoryService;

    /**
    * 查询文章分类详情
    * @return 单条数据
    */
    @GetMapping("/detail/{id}")
    public Result getById(@PathVariable Integer id) {
        return Result.success(categoryService.selectById(id));
    }


    /**
     * 添加文章分类
     * @param category 分类
     * @return 返回结果
     */
    @PostMapping
    public Result insert(@RequestBody @Validated Category category) {
        return categoryService.insertCategory(category);
    }


    /**
     * 更新文章分类
     * @param category 分类
     * @return 返回结果
     */
    @PutMapping
    public Result update(@RequestBody @Validated Category category) {
        return categoryService.updateCategory(category);
    }


    /**
     * 获取文章分类列表
     * @return 返回结果
     */
    @GetMapping
    public Result list(){
        return categoryService.selectList();
    }


    /**
     * 删除文章分类
     * @param id 分类id
     * @return 返回结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return categoryService.delete(id);
    }

}
