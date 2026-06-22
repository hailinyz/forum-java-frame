package com.blog.service;

import com.blog.entity.Comment;
import java.util.List;

public interface CommentService {
    Comment findById(Long id);
    List<Comment> findByArticleId(Long articleId);
    List<Comment> findByUserId(Long userId);
    
    void save(Comment comment);
    void deleteById(Long id);
    void deleteByArticleId(Long articleId);
    
    int countByArticleId(Long articleId);
}
