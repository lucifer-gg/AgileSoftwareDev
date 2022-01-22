package com.example.AgileBackEnd.controller;

import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

}
