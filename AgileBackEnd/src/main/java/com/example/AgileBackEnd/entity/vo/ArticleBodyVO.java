package com.example.AgileBackEnd.entity.vo;

import com.example.AgileBackEnd.entity.po.ArticleBodyPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "ArticleBodyVO{" +
                "content='" + content + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleBodyVO that = (ArticleBodyVO) o;
        return Objects.equals(content, that.content) && Objects.equals(contentHtml, that.contentHtml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, contentHtml);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}
