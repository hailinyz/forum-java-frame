package com.blog.service;

import com.blog.entity.Category;
import java.util.List;

public interface CategoryService {
    Category findById(Long id);
    List<Category> findAll();
    void save(Category category);
    void update(Category category);
    void deleteById(Long id);
}
