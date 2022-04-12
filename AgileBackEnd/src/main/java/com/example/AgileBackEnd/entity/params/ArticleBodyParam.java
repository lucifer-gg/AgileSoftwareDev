package com.example.AgileBackEnd.entity.params;

import lombok.Data;

import java.util.Objects;

@Data
public class ArticleBodyParam {

    private String content;
    private String contentHtml;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleBodyParam that = (ArticleBodyParam) o;
        return Objects.equals(content, that.content) && Objects.equals(contentHtml, that.contentHtml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, contentHtml);
    }

    @Override
    public String toString() {
        return "ArticleBodyParam{" +
                "content='" + content + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
                '}';
    }
}