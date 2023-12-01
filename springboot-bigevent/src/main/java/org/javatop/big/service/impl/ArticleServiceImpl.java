package org.javatop.big.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.javatop.big.pojo.model.PageBean;
import org.javatop.big.utils.Result;
import org.javatop.big.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javatop.big.pojo.Article;
import org.javatop.big.mapper.ArticleMapper;
import org.javatop.big.service.ArticleService;
/**
 * @author : Leo
 * @date  2023-11-25 15:39
 * @version 1.0
 * @description :
 */

@Service
public class ArticleServiceImpl implements ArticleService{

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public int deleteById(Integer id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public int insert(Article record) {
        return articleMapper.insert(record);
    }

    @Override
    public int insertSelective(Article record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }

    @Override
    public int updateByIdSelective(Article record) {
        return articleMapper.updateByIdSelective(record);
    }

    @Override
    public int updateById(Article record) {
        return articleMapper.updateById(record);
    }

    @Override
    public int updateBatchSelective(List<Article> list) {
        return articleMapper.updateBatchSelective(list);
    }



    /**
     * 分页查询
     * @param pageNum 页数
     * @param pageSize 每页大小
     * @param categoryId 分类id
     * @param state 状态
     * @return 返回结果
     */
    @Override
    public Result<PageBean<Article>> selectPageList(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //1. 创建PageBean对象
        PageBean<Article> articlePageBean = new PageBean<>();

        //2.开启分页查询
        PageHelper.startPage(pageNum,pageSize);

        //3.调用mapper查询
        Map map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> articleList = articleMapper.selectAllByCategoryIdAndState(categoryId, state,userId);
        Page<Article> page = (Page<Article>) articleList;

        //4.设置数据
        articlePageBean.setItems(page.getResult());
        articlePageBean.setTotal(page.getTotal());

        return Result.success(articlePageBean);
    }


    /**
     * 删除文章
     * @param id 文章id
     * @return 返回结果
     */
    @Override
    public Result delete(Integer id) {
        Map map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        Article article = articleMapper.selectByCreateUserAndId(userId, id);
        if (ObjectUtil.isNotNull(article)){
            int i = articleMapper.deleteById(id);
            if (i > 0) {
                return Result.success("文章删除成功!!!");
            } else {
                return Result.error("文章删除失败!!!");
            }
        }else {
            return Result.error("不能对此文章进行删除操作!!!");
        }
    }



    /**
     * 添加文章
     * @param article 文章
     * @return 返回结果
     */
    @Override
    public Result insertArticle(Article article) {
        Map map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        if (ObjectUtil.isNotNull(article)){
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            article.setCreateUser(userId);
            int i = articleMapper.insert(article);
            if (i > 0) {
                return Result.success("文章添加成功!!!");
            }else {
                return Result.error("文章添加失败!!!");
            }
        }else {
            return Result.error("文章不能为空!!!");
        }
    }


    /**
     * 更新文章
     * @param article 文章
     * @return 返回结果
     */
    @Override
    public Result update(Article article) {
        if (ObjectUtil.isNull(article.getId())){
            return Result.error("文章ID不能为空!!!");
        }
        if (ObjectUtil.isNotNull(article)) {
            Map map = ThreadLocalUtil.get();
            Integer id = (Integer) map.get("id");
            Article queryArticle = articleMapper.selectByCreateUserAndId(id, article.getId());
            if (ObjectUtil.isNotNull(queryArticle)){
                article.setUpdateTime(new Date());
                int i = articleMapper.updateByIdSelective(article);
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
}
