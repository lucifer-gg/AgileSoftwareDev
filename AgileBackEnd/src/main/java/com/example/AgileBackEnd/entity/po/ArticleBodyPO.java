package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@TableName("ms_article_body")
public class ArticleBodyPO {
    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "ArticleBodyPO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                ", articleId=" + articleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleBodyPO that = (ArticleBodyPO) o;
        return Objects.equals(id, that.id) && Objects.equals(content, that.content) && Objects.equals(contentHtml, that.contentHtml) && Objects.equals(articleId, that.articleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, contentHtml, articleId);
    }
}
