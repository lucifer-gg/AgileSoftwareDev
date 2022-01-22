package com.example.AgileBackEnd.entity.params;

import lombok.Data;

@Data
public class ArticleCommentParam {

    private Long articleId;
    private String content;
    private Long parent;
    private Long toUserId;
}