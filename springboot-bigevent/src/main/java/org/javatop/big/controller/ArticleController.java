package org.javatop.big.controller;

import org.javatop.big.pojo.Article;
import org.javatop.big.pojo.model.PageBean;
import org.javatop.big.service.ArticleService;
import org.javatop.big.service.impl.ArticleServiceImpl;
import org.javatop.big.utils.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

/**
 * @author : Leo
 * @version 1.0
 * @date Sat Nov 25 15:39:27 CST 2023
 * @description : (article)表控制层
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 通过id查询详情
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Article getById(@PathVariable Integer id) {
        return articleService.selectById(id);
    }

    /**
     * 添加文章
     * @param article
     * @return 返回结果
     */
    @PostMapping
    public Result insert(@RequestBody @Validated Article article) {
        return articleService.insertArticle(article);
    }


    /**
     * 更新文章
     * @param article
     * @return 返回结果
     */
    @PutMapping
    public Result update(@RequestBody Article article) {
        return articleService.update(article);
    }


    /**
     * 获取文章列表
     * @return 返回结果
     */
    @GetMapping
    public Result<PageBean<Article>> pageList(Integer pageNum, Integer pageSize,
                                              @RequestParam(required = false) Integer categoryId,
                                              @RequestParam(required = false) String state) {

        return articleService.selectPageList(pageNum, pageSize, categoryId, state);
    }


    /**
     * 删除文章
     * @param id
     * @return 返回结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return articleService.delete(id);
    }

}
