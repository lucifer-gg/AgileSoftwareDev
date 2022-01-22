package com.example.AgileBackEnd.service;

import com.example.AgileBackEnd.entity.params.ArticleCommentParam;
import com.example.AgileBackEnd.entity.vo.Response;

public interface CommentService {
    Response findCommentsByArticleId(Long articleId);
    Response addComment(ArticleCommentParam commentParam);
}
