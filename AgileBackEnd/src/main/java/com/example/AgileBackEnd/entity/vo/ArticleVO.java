package com.example.AgileBackEnd.entity.vo;



import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class ArticleVO {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;
    private String title;
    private String summary;
    private Integer commentCounts;
    private Integer viewCounts;
    private Integer weight;
    private String createDate;
    private String author;
    private ArticleBodyVO body;
    private List<TagVO> tags;
    private ArticleCategoryVO articleCategoryVo;

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ArticleBodyVO getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", commentCounts=" + commentCounts +
                ", viewCounts=" + viewCounts +
                ", weight=" + weight +
                ", createDate='" + createDate + '\'' +
                ", author='" + author + '\'' +
                ", body=" + body +
                ", tags=" + tags +
                ", articleCategoryVo=" + articleCategoryVo +
                '}';
    }

    public void setBody(ArticleBodyVO body) {
        this.body = body;
    }

    public List<TagVO> getTags() {
        return tags;
    }

    public void setTags(List<TagVO> tags) {
        this.tags = tags;
    }

    public ArticleCategoryVO getArticleCategoryVo() {
        return articleCategoryVo;
    }

    public void setArticleCategoryVo(ArticleCategoryVO articleCategoryVo) {
        this.articleCategoryVo = articleCategoryVo;
    }
}