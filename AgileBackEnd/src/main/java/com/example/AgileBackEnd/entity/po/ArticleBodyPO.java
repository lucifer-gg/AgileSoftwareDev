package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("ms_article_body")
public class ArticleBodyPO {
    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;
}
