package com.example.AgileBackEnd.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticleCommentVO {
    private String id;
    private UserVO author;
    private String content;
    private List<ArticleCommentVO> childrens;
    private String createDate;
    private Integer level;
    private UserVO toUser;
}