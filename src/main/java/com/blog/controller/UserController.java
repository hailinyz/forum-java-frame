package com.blog.controller;

import com.blog.entity.Article;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        return "user/profile";
    }
    
    @PostMapping("/update")
    public String updateProfile(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user/profile";
    }
    
    @PostMapping("/password")
    public String updatePassword(@AuthenticationPrincipal UserDetails userDetails,
                                @RequestParam String oldPassword,
                                @RequestParam String newPassword,
                                @RequestParam String confirmPassword,
                                Model model) {
        
        try {
            if (!newPassword.equals(confirmPassword)) {
                model.addAttribute("passwordError", "两次输入的密码不一致");
                User user = userService.findByUsername(userDetails.getUsername());
                model.addAttribute("user", user);
                return "user/profile";
            }
            
            User user = userService.findByUsername(userDetails.getUsername());
            userService.updatePassword(user.getId(), oldPassword, newPassword);
            model.addAttribute("passwordSuccess", "密码修改成功");
        } catch (RuntimeException e) {
            model.addAttribute("passwordError", e.getMessage());
        }
        
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("user", user);
        return "user/profile";
    }
    
    @GetMapping("/articles")
    public String myArticles(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        List<Article> articles = articleService.findByUserId(user.getId());
        model.addAttribute("articles", articles);
        return "user/articles";
    }
    
    @GetMapping("/comments")
    public String myComments(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername());
        List<Comment> comments = commentService.findByUserId(user.getId());
        model.addAttribute("comments", comments);
        return "user/comments";
    }
    
    // 注册功能
    @PostMapping("/register")
    public String register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email,
                          @RequestParam String nickname,
                          Model model) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setNickname(nickname);
            
            userService.register(user);
            return "redirect:/login?register=success";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
