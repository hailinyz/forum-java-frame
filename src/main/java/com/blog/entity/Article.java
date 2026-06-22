package com.blog.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Article {
    private Long id;
    private Long userId;
    private Long categoryId;
    private String title;
    private String summary;
    private String content;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    
    // 关联字段
    private String categoryName;
    private String authorName;
}
