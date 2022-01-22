package com.example.AgileBackEnd.service;

import com.example.AgileBackEnd.entity.params.ArticleCommentParam;
import com.example.AgileBackEnd.entity.params.ArticleParam;
import com.example.AgileBackEnd.entity.params.PageParams;
import com.example.AgileBackEnd.entity.vo.ArticleCategoryVO;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.entity.vo.TagVO;

import java.util.List;

public interface ArticleService {
    Response listArticle(PageParams pageParams);
    Response hotArticle(int limit);
    Response newArticles(int limit);
    Response listArchives();
    Response findArticleById(Long articleId);
    Response publishArticle(ArticleParam articleParam);

}
