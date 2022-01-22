package com.example.AgileBackEnd.entity.vo;

import com.example.AgileBackEnd.entity.po.ArticleBodyPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBodyVO {

    private String content;
    private String contentHtml;

    public ArticleBodyVO(ArticleBodyPO articleBodyPO){
        this.content=articleBodyPO.getContent();
        this.contentHtml=articleBodyPO.getContentHtml();
    }
}
