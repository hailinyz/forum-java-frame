package com.blog.mapper;

import com.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CategoryMapper {
    Category findById(Long id);
    List<Category> findAll();
    List<Category> findByStatus(Integer status);
    int insert(Category category);
    int update(Category category);
    int deleteById(Long id);
}
