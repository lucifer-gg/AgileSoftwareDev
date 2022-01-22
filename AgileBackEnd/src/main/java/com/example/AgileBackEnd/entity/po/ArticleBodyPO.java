package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ms_article_body")
public class ArticleBodyPO {
    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
