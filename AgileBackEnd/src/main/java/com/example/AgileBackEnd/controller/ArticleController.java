package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.dao.mapper.ArticleCategoryMapper;
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
    @PostMapping
    public Response listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    @PostMapping("/articles/hot")
    public Response hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @PostMapping("/articles/new")
    public Response newArticles(){
        int limit = 5;
        return articleService.newArticles(limit);
    }


    @PostMapping("/articles/listArchives")
    public Response listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("/articles/view/{id}")
    public Response findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    @PostMapping("/articles/publish")
    public Response publish(@RequestBody ArticleParam articleParam){
        return articleService.publishArticle(articleParam);
    }
    @GetMapping("/categorys")
    public Response categories(){
        return categoryService.findAllCategory();
    }

    @GetMapping("/categorys/detail")
    public Response categoriesDetail(){
        return categoryService.findAllCategoryDetail();
    }

    @GetMapping("/categorys/detail/{id}")
    public Response categoriesDetailById(@PathVariable("id") Long id){
        return categoryService.findCategoryDetailById(id);
    }

    @GetMapping("/comments/article/{id}")
    public Response comments(@PathVariable("id") Long id){
        return commentService.findCommentsByArticleId(id);
    }

    @PostMapping("/comments/create/change")
    public Response comment(@RequestBody ArticleCommentParam commentParam){
        return commentService.addComment(commentParam);
    }



}
