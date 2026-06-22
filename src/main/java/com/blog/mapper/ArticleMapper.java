package com.blog.mapper;

import com.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ArticleMapper {
    Article findById(Long id);
    List<Article> findAll();
    List<Article> findByUserId(Long userId);
    List<Article> findByCategoryId(Long categoryId);
    List<Article> findByStatus(Integer status);
    
    List<Article> findByPage(@Param("offset") int offset, 
                             @Param("limit") int limit,
                             @Param("categoryId") Long categoryId,
                             @Param("keyword") String keyword);
    
    int count(@Param("categoryId") Long categoryId, 
              @Param("keyword") String keyword);
    
    int insert(Article article);
    int update(Article article);
    int deleteById(Long id);
    
    int incrementViewCount(Long id);
    int incrementLikeCount(Long id);
}
