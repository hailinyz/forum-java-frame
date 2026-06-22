package com.blog.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private Long articleId;
    private Long userId;
    private Long parentId;
    private String content;
    private Integer status;
    private LocalDateTime createTime;
    
    // 关联字段
    private String userName;
    private String userAvatar;
}
