package com.blog.service.impl;

import com.blog.entity.Article;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.CommentMapper;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    
    @Autowired
    private ArticleMapper articleMapper;
    
    @Autowired
    private CommentMapper commentMapper;
    
    @Override
    public Article findById(Long id) {
        return articleMapper.findById(id);
    }
    
    @Override
    public List<Article> findAll() {
        return articleMapper.findAll();
    }
    
    @Override
    public List<Article> findByUserId(Long userId) {
        return articleMapper.findByUserId(userId);
    }
    
    @Override
    public List<Article> findByPage(int page, int size, Long categoryId, String keyword) {
        int offset = (page - 1) * size;
        return articleMapper.findByPage(offset, size, categoryId, keyword);
    }
    
    @Override
    public int count(Long categoryId, String keyword) {
        return articleMapper.count(categoryId, keyword);
    }
    
    @Override
    public void save(Article article) {
        article.setStatus(1);
        articleMapper.insert(article);
    }
    
    @Override
    public void update(Article article) {
        article.setStatus(1);  // 确保文章状态为已发布
        articleMapper.update(article);
    }
    
    @Override
    @Transactional
    public void deleteById(Long id) {
        articleMapper.deleteById(id);
        commentMapper.deleteByArticleId(id);
    }
    
    @Override
    public void incrementViewCount(Long id) {
        articleMapper.incrementViewCount(id);
    }
    
    @Override
    public void incrementLikeCount(Long id) {
        articleMapper.incrementLikeCount(id);
    }
}
