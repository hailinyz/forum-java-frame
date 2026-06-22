package com.blog.service.impl;

import com.blog.entity.Category;
import com.blog.mapper.CategoryMapper;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;
    
    @Override
    public Category findById(Long id) {
        return categoryMapper.findById(id);
    }
    
    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }
    
    @Override
    public void save(Category category) {
        categoryMapper.insert(category);
    }
    
    @Override
    public void update(Category category) {
        categoryMapper.update(category);
    }
    
    @Override
    public void deleteById(Long id) {
        categoryMapper.deleteById(id);
    }
}
