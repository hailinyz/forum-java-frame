package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.Category;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }
    
    @GetMapping("/index")
    public String home(@RequestParam(defaultValue = "1") int page,
                      @RequestParam(defaultValue = "10") int size,
                      @RequestParam(required = false) Long categoryId,
                      @RequestParam(required = false) String keyword,
                      Model model) {
        
        List<Article> articles = articleService.findByPage(page, size, categoryId, keyword);
        int total = articleService.count(categoryId, keyword);
        List<Category> categories = categoryService.findAll();
        
        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", (int) Math.ceil((double) total / size));
        model.addAttribute("currentCategory", categoryId);
        model.addAttribute("keyword", keyword);
        
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
