package org.javatop.big.controller;

import org.javatop.big.pojo.Category;
import org.javatop.big.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * @author : Leo
 * @version 1.0
 * @date Sat Nov 25 13:00:06 CST 2023
 * @description : (category)表控制层
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryServiceImpl categoryServiceImpl;

    /**
     * 获取文章分类详情
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return categoryServiceImpl.selectById(id);
    }

}
