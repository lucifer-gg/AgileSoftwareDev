package com.example.AgileBackEnd.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticleVO {
    private String id;
    private String title;
    private String summary;
    private Integer commentCounts;
    private Integer viewCounts;
    private Integer weight;
    private String createDate;
    private String author;
    private ArticleBodyVO body;
    private List<TagVO> tags;
    private ArticleCategoryVO articleCategoryVo;

}