package com.blog.service.impl;

import com.blog.entity.Comment;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentMapper commentMapper;
    
    @Override
    public Comment findById(Long id) {
        return commentMapper.findById(id);
    }
    
    @Override
    public List<Comment> findByArticleId(Long articleId) {
        return commentMapper.findByArticleId(articleId);
    }
    
    @Override
    public List<Comment> findByUserId(Long userId) {
        return commentMapper.findByUserId(userId);
    }
    
    @Override
    public void save(Comment comment) {
        commentMapper.insert(comment);
    }
    
    @Override
    public void deleteById(Long id) {
        commentMapper.deleteById(id);
    }
    
    @Override
    public void deleteByArticleId(Long articleId) {
        commentMapper.deleteByArticleId(articleId);
    }
    
    @Override
    public int countByArticleId(Long articleId) {
        return commentMapper.countByArticleId(articleId);
    }
}
