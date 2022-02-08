package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.aop.cacheAspect.Cache;
import com.example.AgileBackEnd.aop.logAspect.LogAnnotation;
import com.example.AgileBackEnd.entity.params.ArticleCommentParam;
import com.example.AgileBackEnd.entity.params.ArticleParam;
import com.example.AgileBackEnd.entity.params.PageParams;
import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.service.ArticleService;
import com.example.AgileBackEnd.service.CategoryService;
import com.example.AgileBackEnd.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/articles")
    @LogAnnotation("获取文章列表")
    @Cache(expire = 5 * 60 * 1000,name = "listArticle")
    public Response listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    @LogAnnotation("获取热门文章")
    @Cache(expire = 5 * 60 * 1000,name = "hot_article")
    @PostMapping("/articles/hot")
    public Response hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @LogAnnotation("获取最新文章")
    @Cache(expire = 5 * 60 * 1000,name = "news_article")
    @PostMapping("/articles/new")
    public Response newArticles(){
        int limit = 5;
        return articleService.newArticles(limit);
    }

    @LogAnnotation("获取文章统计信息")
    @PostMapping("/articles/listArchives")
    public Response listArchives(){
        return articleService.listArchives();
    }

    @LogAnnotation("浏览文章")
    @PostMapping("/articles/view/{id}")
    public Response findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    @LogAnnotation("发表文章")
    @PostMapping("/articles/publish")
    public Response publish(@RequestBody ArticleParam articleParam){
        return articleService.publishArticle(articleParam);
    }

    @LogAnnotation("获取所有的分类的简略信息")
    @GetMapping("/categorys")
    public Response categories(){
        return categoryService.findAllCategory();
    }

    @LogAnnotation("获取所有分类的具体信息")
    @GetMapping("/categorys/detail")
    public Response categoriesDetail(){
        return categoryService.findAllCategoryDetail();
    }

    @LogAnnotation("获取某个分类的具体信息")
    @GetMapping("/categorys/detail/{id}")
    public Response categoriesDetailById(@PathVariable("id") Long id){
        return categoryService.findCategoryDetailById(id);
    }

    @LogAnnotation("获取文章的评论")
    @GetMapping("/comments/article/{id}")
    public Response comments(@PathVariable("id") Long id){
        return commentService.findCommentsByArticleId(id);
    }

    @LogAnnotation("为文章添加评论")
    @PostMapping("/comments/create/change")
    public Response comment(@RequestBody ArticleCommentParam commentParam){
        return commentService.addComment(commentParam);
    }



}
