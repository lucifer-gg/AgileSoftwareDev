package com.example.AgileBackEnd.entity.params;

import lombok.Data;

import java.util.Objects;

@Data
public class ArticleCommentParam {

    private Long articleId;
    private String content;
    private Long parent;
    private Long toUserId;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleCommentParam that = (ArticleCommentParam) o;
        return Objects.equals(articleId, that.articleId) && Objects.equals(content, that.content) && Objects.equals(parent, that.parent) && Objects.equals(toUserId, that.toUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, content, parent, toUserId);
    }

    @Override
    public String toString() {
        return "ArticleCommentParam{" +
                "articleId=" + articleId +
                ", content='" + content + '\'' +
                ", parent=" + parent +
                ", toUserId=" + toUserId +
                '}';
    }
}