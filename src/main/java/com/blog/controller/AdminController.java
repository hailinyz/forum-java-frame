package com.blog.controller;

import com.blog.entity.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private CategoryService categoryService;
    
    // ==================== 分类管理 ====================
    
    @GetMapping("/categories")
    public String categories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new Category());
        return "admin/categories";
    }
    
    @PostMapping("/category/save")
    public String saveCategory(@ModelAttribute Category category) {
        if (category.getSort() == null) {
            category.setSort(0);
        }
        categoryService.save(category);
        return "redirect:/admin/categories";
    }
    
    @PostMapping("/category/update")
    public String updateCategory(@ModelAttribute Category category) {
        categoryService.update(category);
        return "redirect:/admin/categories";
    }
    
    @PostMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }
}
