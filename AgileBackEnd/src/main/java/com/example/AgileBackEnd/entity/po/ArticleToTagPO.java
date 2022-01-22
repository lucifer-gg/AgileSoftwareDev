package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ms_article_tag")
public class ArticleToTagPO {
    private Long id;
    private Long articleId;
    private Long tagId;
}
