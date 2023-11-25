package org.javatop.big.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
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

}
