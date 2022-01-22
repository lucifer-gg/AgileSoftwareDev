package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ms_comment")
public class ArticleCommentPO {
    private Long id;
    private String content;
    private Long createDate;
    private Long articleId;
    private Long authorId;
    private Long parentId;
    private Long toUid;
    private Integer level;
}
