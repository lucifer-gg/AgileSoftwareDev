package com.example.AgileBackEnd.entity.params;

import com.example.AgileBackEnd.entity.vo.ArticleCategoryVO;
import com.example.AgileBackEnd.entity.vo.TagVO;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private ArticleCategoryVO category;

    private String summary;

    private List<TagVO> tags;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArticleBodyParam getBody() {
        return body;
    }

    public void setBody(ArticleBodyParam body) {
        this.body = body;
    }

    public ArticleCategoryVO getCategory() {
        return category;
    }

    public void setCategory(ArticleCategoryVO category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<TagVO> getTags() {
        return tags;
    }

    public void setTags(List<TagVO> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleParam that = (ArticleParam) o;
        return Objects.equals(id, that.id) && Objects.equals(body, that.body) && Objects.equals(category, that.category) && Objects.equals(summary, that.summary) && Objects.equals(tags, that.tags) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, category, summary, tags, title);
    }

    @Override
    public String toString() {
        return "ArticleParam{" +
                "id=" + id +
                ", body=" + body +
                ", category=" + category +
                ", summary='" + summary + '\'' +
                ", tags=" + tags +
                ", title='" + title + '\'' +
                '}';
    }
}