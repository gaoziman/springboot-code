package org.javatop.big.controller;
import org.javatop.big.pojo.Article;
import org.javatop.big.service.impl.ArticleServiceImpl;
import org.javatop.big.utils.Result;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
* @author : Leo
* @date  Sat Nov 25 15:39:27 CST 2023
* @version 1.0
* @description : (article)表控制层
*/
@RestController
@RequestMapping("/article")
public class ArticleController {
 
    @Resource
    private ArticleServiceImpl articleServiceImpl;

    /**
    * 通过id查询详情
    *
    * @param id 主键
    * @return 单条数据
    */
    @GetMapping("/{id}")
    public Article getById(@PathVariable Integer id) {
        return articleServiceImpl.selectById(id);
    }

    /**
    * 添加
    * @param
    * @return 返回结果
    */
    @PostMapping
    public Result insert(@RequestBody Article entity) {
        return articleServiceImpl.insert(entity);
    }
    
    
    /**
    * 更新
    * @param  
    * @return 返回结果
    */
    @PutMapping
    public Result update(@RequestBody  Article entity) {
        return articleServiceImpl.update(entity);
    }
    
    
    /**
    * 获取列表
    * @return 返回结果
    */
    @GetMapping
    public Result list(){
        return articleServiceImpl.selectList();
    }
    
    
    /**
    * 删除
    * @param id 
    * @return 返回结果
    */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return articleServiceImpl.delete(id);
    }

}
