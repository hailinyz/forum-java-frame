package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.Category;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        if (article == null) {
            return "redirect:/index";
        }
        
        articleService.incrementViewCount(id);
        
        // Markdown转HTML
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Document document = parser.parse(article.getContent());
        String htmlContent = renderer.render(document);
        
        List<Comment> comments = commentService.findByArticleId(id);
        List<Category> categories = categoryService.findAll();
        
        model.addAttribute("article", article);
        model.addAttribute("htmlContent", htmlContent);
        model.addAttribute("comments", comments);
        model.addAttribute("categories", categories);
        
        return "article/detail";
    }
    
    @GetMapping("/new")
    public String newArticle(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("article", new Article());
        return "article/form";
    }
    
    @PostMapping("/save")
    public String saveArticle(@ModelAttribute Article article,
                             @AuthenticationPrincipal UserDetails userDetails) {
        // 从当前登录用户获取用户ID
        User user = userService.findByUsername(userDetails.getUsername());
        article.setUserId(user.getId());
        
        articleService.save(article);
        return "redirect:/article/" + article.getId();
    }
    
    @GetMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        if (article == null) {
            return "redirect:/index";
        }
        List<Category> categories = categoryService.findAll();
        
        model.addAttribute("article", article);
        model.addAttribute("categories", categories);
        return "article/form";
    }
    
    @PostMapping("/update")
    public String updateArticle(@ModelAttribute Article article,
                               @AuthenticationPrincipal UserDetails userDetails) {
        // 从当前登录用户获取用户ID
        User user = userService.findByUsername(userDetails.getUsername());
        article.setUserId(user.getId());
        
        articleService.update(article);
        return "redirect:/article/" + article.getId();
    }
    
    @PostMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteById(id);
        return "redirect:/index";
    }
    
    @PostMapping("/like/{id}")
    @ResponseBody
    public String likeArticle(@PathVariable Long id) {
        articleService.incrementLikeCount(id);
        return "success";
    }
}
