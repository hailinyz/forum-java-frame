package com.blog.mapper;

import com.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface CommentMapper {
    Comment findById(Long id);
    List<Comment> findByArticleId(Long articleId);
    List<Comment> findByUserId(Long userId);
    
    int insert(Comment comment);
    int update(Comment comment);
    int deleteById(Long id);
    int deleteByArticleId(Long articleId);
    
    int countByArticleId(Long articleId);
}
