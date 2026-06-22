package com.blog.service;

import com.blog.entity.Article;
import java.util.List;

public interface ArticleService {
    Article findById(Long id);
    List<Article> findAll();
    List<Article> findByUserId(Long userId);
    List<Article> findByPage(int page, int size, Long categoryId, String keyword);
    int count(Long categoryId, String keyword);
    
    void save(Article article);
    void update(Article article);
    void deleteById(Long id);
    
    void incrementViewCount(Long id);
    void incrementLikeCount(Long id);
}
