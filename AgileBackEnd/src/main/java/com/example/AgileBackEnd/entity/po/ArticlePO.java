package com.example.AgileBackEnd.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Objects;

@Data
@TableName("ms_article")
public class ArticlePO {
    public static final int Article_TOP = 1;
    public static final int Article_Common = 0;
    private Long id;
    private String title;
    private String summary;
    private Integer commentCounts;
    private Integer viewCounts;
    private Long authorId;
    private Long bodyId;
    private Long categoryId;
    private Integer weight;
    private Long createDate;

    @Override
    public String toString() {
        return "ArticlePO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", commentCounts=" + commentCounts +
                ", viewCounts=" + viewCounts +
                ", authorId=" + authorId +
                ", bodyId=" + bodyId +
                ", categoryId=" + categoryId +
                ", weight=" + weight +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticlePO articlePO = (ArticlePO) o;
        return Objects.equals(id, articlePO.id) && Objects.equals(title, articlePO.title) && Objects.equals(summary, articlePO.summary) && Objects.equals(commentCounts, articlePO.commentCounts) && Objects.equals(viewCounts, articlePO.viewCounts) && Objects.equals(authorId, articlePO.authorId) && Objects.equals(bodyId, articlePO.bodyId) && Objects.equals(categoryId, articlePO.categoryId) && Objects.equals(weight, articlePO.weight) && Objects.equals(createDate, articlePO.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, summary, commentCounts, viewCounts, authorId, bodyId, categoryId, weight, createDate);
    }

    public static int getArticle_TOP() {
        return Article_TOP;
    }

    public static int getArticle_Common() {
        return Article_Common;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    public Integer getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBodyId() {
        return bodyId;
    }

    public void setBodyId(Long bodyId) {
        this.bodyId = bodyId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}
