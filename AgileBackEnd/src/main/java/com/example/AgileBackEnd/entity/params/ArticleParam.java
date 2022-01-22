package com.example.AgileBackEnd.entity.params;

import com.example.AgileBackEnd.entity.vo.ArticleCategoryVO;
import com.example.AgileBackEnd.entity.vo.TagVO;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private ArticleCategoryVO category;

    private String summary;

    private List<TagVO> tags;

    private String title;
}