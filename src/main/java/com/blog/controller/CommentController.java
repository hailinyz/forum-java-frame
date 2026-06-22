package com.blog.controller;

import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.service.CommentService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/save")
    public String saveComment(@RequestParam("articleId") Long articleId,
                             @RequestParam(value = "parentId", defaultValue = "0") Long parentId,
                             @RequestParam("content") String content,
                             @AuthenticationPrincipal UserDetails userDetails) {
        
        // 从当前登录用户获取用户ID
        User user = userService.findByUsername(userDetails.getUsername());
        
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setParentId(parentId != null ? parentId : 0L);
        comment.setContent(content);
        comment.setUserId(user.getId());
        
        commentService.save(comment);
        return "redirect:/article/" + articleId;
    }
    
    @PostMapping("/delete/{id}")
    public String deleteComment(@PathVariable("id") Long id,
                               @RequestParam("articleId") Long articleId) {
        commentService.deleteById(id);
        return "redirect:/article/" + articleId;
    }
}
